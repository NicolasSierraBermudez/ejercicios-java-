package com.practicajava.ejercicio13;

/**
 * Ejercicio 13 - Clase base Producto.
 * Las subclases añaden información específica sobrescribiendo getDetalle().
 */
public class Producto {

    protected final int codigo;
    protected final String nombre;
    protected final double precio;

    public Producto(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    /** Información adicional según el tipo de producto. */
    public String getDetalle() {
        return "Producto general";
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

    @Override
    public String toString() {
        return String.format("[%d] %-20s $%9.2f  | %s", codigo, nombre, precio, getDetalle());
    }
}
