package com.practicajava.ejercicio11;

import java.util.ArrayList;

/**
 * Ejercicio 11 - Carrito de compras sencillo.
 */
public class Carrito {

    private final ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    public void mostrar() {
        System.out.println("Carrito:");
        if (productos.isEmpty()) {
            System.out.println("  (vacío)");
        }
        for (Producto p : productos) {
            System.out.println("  " + p);
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
    }
}
