package com.aluracursos.Challenge_LiterAlura.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Se implementa la interfase IConvierteDatos
public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> Clase) {//implementa los datos de la interfase (iConvierteDatos)
        try {
            return objectMapper.readValue(json, Clase);//el metodo "readValue" puede retornar una "Excepción" es necesario tratarla por eso se encierra en el bloque "try"/"catch".
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}