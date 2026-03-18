package com.example.list_view.Models;

import androidx.annotation.NonNull;

public class Producto {
    private int imagen;
    private String nombreProducto;
    private String descripcion;
    private double precio;

    public Producto() {
    }

    public Producto(int imagen, String nombreProducto, double precio) {
        this.imagen = imagen;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.descripcion = "";
    }

    public Producto(int imagen, String nombreProducto, String descripcion, double precio) {
        this.imagen = imagen;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                '}';
    }
}
