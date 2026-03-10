package com.example.list_view.Models;

import android.widget.ImageView;

public class Producto {

    private String Nombre;

    private Double precio;

    private int imagen;

    public Producto(String nombre, Double precio, int imagen) {
        Nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
