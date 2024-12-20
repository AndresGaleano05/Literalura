package com.aluracursos.Challenge_LiterAlura.Principal;

import com.aluracursos.Challenge_LiterAlura.Model.Datos;
import com.aluracursos.Challenge_LiterAlura.Model.DatosLibros;
import com.aluracursos.Challenge_LiterAlura.Service.ConsumoApi;
import com.aluracursos.Challenge_LiterAlura.Service.ConvierteDatos;

import java.util.*;


public class Principal {
    //variable de ambiente
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();


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
      System.out.println(json);
      //"?search=" es el nombre que va a buscar dependiendo lo escrito por el cliente y se remplaza los espacios x "+". Ejemplo: Don quijote = Don+quijote
      var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

      Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()//<DatosLibros> ya es una lista que está en el record
              .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
              .findFirst();//es para que encuentre el primer resultado que obtenga
      if (libroBuscado.isPresent()) {
          System.out.println("Libro encontrado");
          System.out.println(libroBuscado.get());
          datosLibros.add(libroBuscado.get());
      } else {
          System.out.println("Libro no encontrado");
      }
      return datosBusqueda;
    }

    private void librosRegistrados() {
       if (datosLibros.isEmpty()) {
           System.out.println("No hay libros registrados.");
           return;
       }
        System.out.println("Libros registrados: ");
       for (DatosLibros libro: datosLibros) {
           System.out.println(libro);

       }
    }

    private void autoresRegistrados() {

    }




}






            //CODIGO VIEJO

//
//            var json = consumoApi.obtenerDatos(URL_BASE);
//            System.out.println(json);
//            // Se crea variable "datos" que es igual a conversor.obtenerDatos que toma los datos del json y los convierte en una lista del tipo Datos.class
//            var datos = conversor.obtenerDatos(json, Datos.class);
//            System.out.println(datos);
//
//            //Top de los libros más descargados
//            System.out.println("Top 10 de los libros más descargados");
//            datos.resultados().stream()
//                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
///*sorted encuentra los datos, comparator.comparing compara todos los libros,
//DatosLibros::numeroDeDescargas busca que dato va a comparar a traves de las descargas y reversed
//ordena los datos de mayor a menor*/
//                .limit(10)
//                .map(l -> l.titulo().toUpperCase())//toma cada título de los libros y los transforma en mayúscula
//                .forEach(System.out::println);
//
//
//
//            // Trabajar con estadísticas
//
//            // DoubleSummaryStatistics clase prefija para extraer las estadisticas
//            DoubleSummaryStatistics est = datos.resultados().stream()
//                .filter(d->d.numeroDeDescargas() >0 )
//                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
//            System.out.println("Cantidad media de descargas: " + est.getAverage());
//            System.out.println("Cantidad máxima de descargas: " + est.getMax());
//            System.out.println("Cantidad mínima de descargas: " + est.getMin());
//            System.out.println("Cantidad de registros evaluados para calcular las estadísticas: " + est.getCount());
//        }
//    }
