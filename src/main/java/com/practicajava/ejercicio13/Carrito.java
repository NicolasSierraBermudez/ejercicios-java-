package com.practicajava.ejercicio13;

import java.util.ArrayList;

/**
 * Ejercicio 13 - Carrito que acepta cualquier tipo de Producto (polimorfismo).
 * No permite agregar alimentos caducados.
 */
public class Carrito {

    private final ArrayList<Producto> productos = new ArrayList<>();

    public boolean agregarProducto(Producto p) {
        if (p instanceof ProductoAlimenticio alimento && alimento.estaCaducado()) {
            System.out.println("  No se puede agregar: el producto está caducado.");
            return false;
        }
        productos.add(p);
        return true;
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
