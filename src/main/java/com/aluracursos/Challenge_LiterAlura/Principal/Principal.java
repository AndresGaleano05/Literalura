package com.aluracursos.Challenge_LiterAlura.Principal;

import com.aluracursos.Challenge_LiterAlura.Model.*;
import com.aluracursos.Challenge_LiterAlura.Service.ConsumoApi;
import com.aluracursos.Challenge_LiterAlura.Service.ConvierteDatos;
import com.aluracursos.Challenge_LiterAlura.repository.AutoresRepository;
import com.aluracursos.Challenge_LiterAlura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Principal {
    //variable de ambiente
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private List<DatosAutor> autor = new ArrayList<>();
    @Autowired//Es para que sea correctamente inyectado por Spring
    private LibrosRepository LibrosRepositorio;
    @Autowired//Es para que sea correctamente inyectado por Spring
    private AutoresRepository AutoresRepositorio;

    public Principal(LibrosRepository librosRepositorio, AutoresRepository autoresRepositorio) {
        this.LibrosRepositorio=librosRepositorio;
        this.AutoresRepositorio=autoresRepositorio;
    }

    public void muestraElMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    **********************************************
                    
                    Elija la opción que deseas ver:
                    1. Buscar libro por titulo o palabra clave que lo identifique
                    2. Lista libros registrados
                    3. Lista de autores registrados
                    4. Lista de autores vivos en un año especifico
                    5. Lista de los libros por idioma
                    
                    0 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                   buscarPorTitulo();
                    break;

                case 2:
                    librosRegistrados();
                    break;

                case 3:
                    autoresRegistrados();
                break;

                case 4:


                case 5:


                case 0:
                    System.out.println("!La aplicación a finalizado¡");
                    break;
                default:
                    System.out.println("Es una opción invalidad");

            }
        }
    }

    public Datos buscarPorTitulo() {
      System.out.println("Escribe el nombre del libro que deseas buscar para brindarte su información");
      var tituloLibro = teclado.nextLine();
      var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
      //System.out.println(json);
      //"?search=" es el nombre que va a buscar dependiendo lo escrito por el cliente y se remplaza los espacios x "+". Ejemplo: Don quijote = Don+quijote
      var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

      Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()//<DatosLibros> ya es una lista que está en el record
              .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
              .findFirst();//es para que encuentre el primer resultado que obtenga

        if (libroBuscado.isPresent()) {
            DatosLibros datosDelLibro = libroBuscado.get();

            // Obtén un autor válido o crea uno nuevo
            DatosAutor datosAutor = datosDelLibro.autores().get(0); // Tomamos el primer autor de la lista
            Autor autor;

            Optional<Autor> autorExistente = AutoresRepositorio.findByNombreAndFechaDeNacimientoAndFechaDeFallecimiento(
                    datosAutor.nombre(),
                    datosAutor.fechaDeNacimiento(),
                    datosAutor.fechaDeFallecimiento());

            if (autorExistente.isPresent()) {
                autor = autorExistente.get();
            } else {
                autor = new Autor(datosAutor.nombre(), datosAutor.fechaDeNacimiento(), datosAutor.fechaDeFallecimiento());
                AutoresRepositorio.save(autor); // Guardamos el autor si es nuevo
            }

            // Ahora crea la instancia del libro
            Libros libro = new Libros(datosDelLibro, autor);
            System.out.println("Libro encontrado");
            System.out.println(libro);

            // Verificamos si el libro ya está guardado en la base de datos
            Optional<Libros> libroGuardado = LibrosRepositorio.findByTitulo(libro.getTitulo());

            if (libroGuardado.isPresent()) {
                System.out.println("**********************************************");
                System.out.println("Este libro se encuentra registrado en nuestra base de datos.");
            } else {
                try {
                    LibrosRepositorio.save(libro);
                    System.out.println("**********************************************");
                    System.out.println(libro);
                    System.out.println("Libro agregado a la base de datos");
                } catch (DataIntegrityViolationException e) {
                    System.out.println("¡No es posible agregar el libro a la base de datos porque ya se encuentra registrado!");
                } catch (Exception e) {
                    System.out.println("Error al guardar el libro: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Libro no encontrado");
        }
        return datosBusqueda;
    }

    private void librosRegistrados() {
        //Se utiliza la instacion "repositorio" para evitar el metodo estatico y que genere error
        List<Libros> libros = LibrosRepositorio.findAll();

        if (libros.isEmpty()) {
           System.out.println("No hay libros registrados.");
           return;
       }
        System.out.println("Libros registrados: ");

        for (int i = 0; i < libros.size(); i++) {
            Libros libro = libros.get(i);

            // Muestra los detalles del libro
            System.out.println("**********************************************");
            System.out.println("Libro #" + (i + 1)); // Muestra el número del libro según los que estén registrados
            System.out.println(libro);//imprime los datos que están registrados en "Libros"
        }

    }

    private void autoresRegistrados() {
        List<Autor> autores = AutoresRepositorio.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }

        System.out.println("Autores registrados:");
        for (int i = 0; i < autores.size(); i++) {
            Autor autor = autores.get(i);

            //Muestra el detalle de los autores
            System.out.println("**********************************************");
            System.out.println("Autor N° " + (i + 1));
            System.out.println(autor);
        }
    }
}







