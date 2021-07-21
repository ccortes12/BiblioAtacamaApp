package com.example.biblioatacamaapp.models;

import java.util.List;

public class User {

    private Integer id;
    private String email;
    private String username;
    private String password;
    private String nombre;
    private String paterno;
    private String materno;
    private String direccion;
    private String telefono;
    private List<Rol> roles;

    public User() {
    }

    public User(Integer id, String email, String username, String password, String nombre, String paterno, String materno, String direccion, String telefono) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
