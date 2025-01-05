package com.aluracursos.Challenge_LiterAlura.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name="Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")//Especifica el nombre de la columna
    private String nombre;
    @Column(name = "fecha_de_nacimiento")//Especifica el nombre de la columna
    private Integer fechaDeNacimiento;
    @Column(name = "fecha_de_fallecimiento")
    private Integer fechaDeFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Libros> libros = new ArrayList<>();

    //Constructor
    public Autor(){}

    public Autor(String nombre, Integer fechaDeNacimiento, Integer fechaDeFallecimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }


    //toString que accede a lista de autores
    @Override
    public String toString() {
        //si la lista no esta vacia "null" utilizamos el String para obtener lostitulos de los libros
        String librosString = this.getLibros() == null || this.getLibros().isEmpty() ? "[]" :
                this.getLibros().stream()
                        .map(l -> "\"" + l.getTitulo()+ "\"")
                        .collect(Collectors.joining(", "));
        return
                "Nombre:'" + nombre + '\'' + "\n" +
                "Fecha de nacimiento:'" + fechaDeNacimiento + '\'' + "\n" +
                "Fecha de fallecimiento:'" + fechaDeFallecimiento +"\n" +
                "Libros del autor: " + librosString;

    }

    //Getters y Setters


    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento =fechaDeFallecimiento;
    }
}
