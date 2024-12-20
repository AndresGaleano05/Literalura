package com.aluracursos.Challenge_LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ignora propiedades que no se están mapeando abajo
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento,
        @JsonAlias("death_year") String fechaDeFallecimiento
) {
}