package com.aluracursos.Challenge_LiterAlura.Service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class <T> Clase);
}
