package com.practicajava.ejercicio15;

/**
 * Ejercicio 15 - Producto con stock disponible.
 */
public class Producto {

    private final int codigo;
    private final String nombre;
    private final double precio;
    private int stock;

    public Producto(int codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    /** Solo el Inventario (mismo paquete) modifica el stock. */
    void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-18s $%8.2f  Stock: %d", codigo, nombre, precio, stock);
    }
}
