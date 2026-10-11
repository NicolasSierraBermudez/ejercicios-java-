package com.practicajava.ejercicio15;

import java.util.ArrayList;

/**
 * Ejercicio 15 - Inventario centralizado con control de stock.
 */
public class Inventario {

    private final ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public boolean hayStock(int codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        return p != null && cantidad > 0 && p.getStock() >= cantidad;
    }

    /** Descuenta stock si hay suficiente. Devuelve true si se pudo descontar. */
    public boolean descontarStock(int codigo, int cantidad) {
        if (!hayStock(codigo, cantidad)) {
            return false;
        }
        Producto p = buscarProducto(codigo);
        p.setStock(p.getStock() - cantidad);
        return true;
    }

    /** Devuelve unidades al inventario (por ejemplo, al quitar del carrito). */
    public void reponerStock(int codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null && cantidad > 0) {
            p.setStock(p.getStock() + cantidad);
        }
    }

    public void mostrar() {
        System.out.println("Inventario:");
        for (Producto p : productos) {
            System.out.println("  " + p + (p.getStock() == 0 ? "  (AGOTADO)" : ""));
        }
    }
}
