package com.example.list_view.Models;

import androidx.annotation.NonNull;

public class Producto {

    private int imagen;

    private String nombreProducto;

    private double precio;

    public Producto(int imagen, String nombreProducto, double precio) {
        this.imagen = imagen;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("Nombre: %s Precio: %f", this.nombreProducto, this.precio);
    }
}
