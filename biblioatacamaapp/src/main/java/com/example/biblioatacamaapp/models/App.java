package com.example.biblioatacamaapp.models;

import android.app.Application;

public class App extends Application{

    private User usuario;

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
