package com.practicajava.ejercicio11;

/**
 * Ejercicio 11 - Producto con categoría.
 */
public class Producto {

    private final int codigo;
    private final String nombre;
    private final double precio;
    private final String categoria;

    public Producto(int codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-22s $%9.2f  (%s)", codigo, nombre, precio, categoria);
    }
}
