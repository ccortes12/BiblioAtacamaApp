package com.example.biblioatacamaapp.models;

import java.util.List;

public class Libro {

    private Integer id;

    private List<Idioma> idioma;

    private List<Categoria> categorias;

    private String nombre;

    private String autor;

    private String editorial;

    private String isbn;

    private String sku;

    private Integer precio;

    private Integer stock;

    private String resenia;

    private String nombreImagen;

    private String nombreArchivo;

    private Integer cantidadPag;

    public Libro() {
    }

    public Libro(Integer id, List<Idioma> idioma, List<Categoria> categorias, String nombre, String autor, String editorial, String isbn, String sku, Integer precio, Integer stock, String resenia, String nombreImagen, String nombreArchivo, Integer cantidadPag) {
        this.id = id;
        this.idioma = idioma;
        this.categorias = categorias;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.sku = sku;
        this.precio = precio;
        this.stock = stock;
        this.resenia = resenia;
        this.nombreImagen = nombreImagen;
        this.nombreArchivo = nombreArchivo;
        this.cantidadPag = cantidadPag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Idioma> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<Idioma> idioma) {
        this.idioma = idioma;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public Integer getCantidadPag() {
        return cantidadPag;
    }

    public void setCantidadPag(Integer cantidadPag) {
        this.cantidadPag = cantidadPag;
    }
}
