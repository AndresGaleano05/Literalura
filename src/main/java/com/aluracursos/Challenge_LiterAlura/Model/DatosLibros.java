package com.aluracursos.Challenge_LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//ignora propiedades que no se están mapeando abajo
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibros(
        @JsonAlias("title") String titulo,
        //Se crea record de <DatosAutor>
        @JsonAlias("authors")List<DatosAutor> autor,
        @JsonAlias("languages")List<String> idiomas,
        @JsonAlias("download_count")Double numeroDeDescargas
) {
}
