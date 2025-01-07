package com.aluracursos.Challenge_LiterAlura.Model;

public enum Idioma {
    ES("es", "español"),
    EN("en", "ingles");

    private final String abreviatura;
    private final String nombreCompleto;

    Idioma(String abreviatura, String nombreCompleto) {
        this.abreviatura = abreviatura;
        this.nombreCompleto = nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public static Idioma fromAbreviatura(String abreviatura) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.abreviatura.equalsIgnoreCase(abreviatura)) {
                return idioma;
            }
        }
        return null;
    }
    public static Idioma fromNombreCompleto(String nombreCompleto) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.nombreCompleto.equalsIgnoreCase(nombreCompleto)) {
                return idioma;
            }
        }
        return null;
    }
}
