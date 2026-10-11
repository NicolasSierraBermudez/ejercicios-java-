package com.practicajava.ejercicio14;

import java.util.ArrayList;

/**
 * Ejercicio 14 - Carrito asociado a un Cliente.
 */
public class Carrito {

    private final Cliente cliente;
    private final ArrayList<Producto> productos = new ArrayList<>();

    public Carrito(Cliente cliente) {
        this.cliente = cliente;
    }

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
        System.out.println("Carrito de " + cliente + ":");
        if (productos.isEmpty()) {
            System.out.println("  (vacío)");
        }
        for (Producto p : productos) {
            System.out.println("  " + p);
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
    }

    public Cliente getCliente() {
        return cliente;
    }
}
