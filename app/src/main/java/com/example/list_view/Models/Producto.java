package com.example.list_view.Models;

public class Producto {

    private String nombre;

    private int imagen;

    private double precio;

    public Producto(String nombre, int imagen, double precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
