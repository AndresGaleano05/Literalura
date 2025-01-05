package com.aluracursos.Challenge_LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name= "Libros")
public class Libros {
    /*private long Id: crea un identificador por cada serie, @Id es el identificador de la tabla
    @GeneratedValue=El programa se encargar de generar automaticamente de crear el Id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@Column(unique = true)=Se utilizapara que no hayan libros repetidos con el mismo nombre en este caso "Titulo"
    @Column(unique = true)
    private String titulo;
    @ManyToOne                                 //cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    private String idiomas;
    private Double numeroDeDescargas;

    //Constructor
    public Libros(){}
    // trae los datos del record DatosLibros
    public Libros(DatosLibros datosLibros, Autor autor) {
        this.titulo = datosLibros.titulo();
        this.autor = autor;
        //this.autores = convierteAutores(datosLibros.autores());
        this.idiomas = String.join(", ",datosLibros.idiomas());
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    //ToString accede a lista de autores

    @Override
    public String toString() {
        //identifica si hay autores y obtiene el nombre del primer autor
        //String autorStr = (autor != null && !autores.isEmpty()) ? autores.get(0).getNombre() : "Autor desconocido";

        return
                "titulo: " + titulo + "\n" +
                "nombre del autor: " + (autor != null ? autor.getNombre(): "Desconocido") + "\n" +
                "idiomas: " + idiomas + "\n" +
                "numero de descargas: " + numeroDeDescargas;
    }


    // getter y setter


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
