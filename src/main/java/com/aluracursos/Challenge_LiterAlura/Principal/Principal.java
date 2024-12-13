package com.aluracursos.Challenge_LiterAlura.Principal;

import com.aluracursos.Challenge_LiterAlura.Service.ConsumoApi;
import com.aluracursos.Challenge_LiterAlura.Service.ConvierteDatos;
import com.aluracursos.Challenge_LiterAlura.Service.IConvierteDatos;

import java.util.Scanner;


public class Principal {
    //variable de ambiente
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
//    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu (){
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}
