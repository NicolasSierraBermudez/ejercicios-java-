package com.practicajava.ejercicio15;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Ejercicio 15 - Carrito que consulta al Inventario antes de agregar
 * productos y descuenta el stock correspondiente.
 */
public class Carrito {

    private final Inventario inventario;
    private final LinkedHashMap<Producto, Integer> items = new LinkedHashMap<>();

    public Carrito(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean agregarProducto(int codigo, int cantidad) {
        Producto p = inventario.buscarProducto(codigo);
        if (p == null) {
            System.out.println("  El producto no existe en el inventario.");
            return false;
        }
        if (!inventario.descontarStock(codigo, cantidad)) {
            System.out.println("  Stock insuficiente o cantidad no válida. Disponible: " + p.getStock());
            return false;
        }
        items.merge(p, cantidad, Integer::sum);
        return true;
    }

    /** Quita un producto del carrito y devuelve las unidades al inventario. */
    public boolean quitarProducto(int codigo) {
        for (Producto p : items.keySet()) {
            if (p.getCodigo() == codigo) {
                inventario.reponerStock(codigo, items.remove(p));
                return true;
            }
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Producto, Integer> e : items.entrySet()) {
            total += e.getKey().getPrecio() * e.getValue();
        }
        return total;
    }

    public void mostrar() {
        System.out.println("Carrito:");
        if (items.isEmpty()) {
            System.out.println("  (vacío)");
        }
        for (Map.Entry<Producto, Integer> e : items.entrySet()) {
            System.out.printf("  %-18s x%-3d $%9.2f%n", e.getKey().getNombre(), e.getValue(), e.getKey().getPrecio() * e.getValue());
        }
        System.out.printf("Total: $%.2f%n", calcularTotal());
    }

    /** Confirma la compra: el stock ya fue descontado, solo se vacía el carrito. */
    public void finalizarCompra() {
        mostrar();
        items.clear();
        System.out.println("¡Compra finalizada! Gracias.");
    }
}
