package com.aluracursos.Challenge_LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//ignora propiedades que no se están mapeando abajo
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        //Se agrega el alias "results" de la API y Se crea record de <DatosLibros>
        @JsonAlias("results") List<DatosLibros> resultados
) {
}
