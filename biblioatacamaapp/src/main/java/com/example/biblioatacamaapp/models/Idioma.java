package com.example.biblioatacamaapp.models;

public class Idioma {

    private Integer id;

    private String nombre;

    public Idioma(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Idioma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
