package com.aluracursos.Challenge_LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name= "Libros")
public class Libros {
    private long id;
    private String titulo;
    private  String autor;
    private String idiomas;
    private Double numeroDeDescargas;


    // trae los datos del record DatosLibros
    public Libros(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.autor = String.valueOf(datosLibros.autor());
        this.idiomas = String.valueOf(datosLibros.idiomas());
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    //ToString

    @Override
    public String toString() {
        return
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas;
    }


    // getter y setter

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
