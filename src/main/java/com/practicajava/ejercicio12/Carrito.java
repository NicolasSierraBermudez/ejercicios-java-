package com.practicajava.ejercicio12;

import java.util.ArrayList;

/**
 * Ejercicio 12 - Carrito con sistema de descuentos.
 * Si el subtotal supera $1000 se aplica un 10 % de descuento.
 */
public class Carrito {

    public static final double UMBRAL_DESCUENTO = 1000.0;
    public static final double PORCENTAJE_DESCUENTO = 0.10;

    private final ArrayList<Producto> productos = new ArrayList<>();
    private final ArrayList<Integer> cantidades = new ArrayList<>();

    public void agregarProducto(Producto p, int cantidad) {
        if (cantidad <= 0) {
            return;
        }
        int idx = productos.indexOf(p);
        if (idx >= 0) {
            cantidades.set(idx, cantidades.get(idx) + cantidad);
        } else {
            productos.add(p);
            cantidades.add(cantidad);
        }
    }

    public void vaciar() {
        productos.clear();
        cantidades.clear();
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < productos.size(); i++) {
            subtotal += productos.get(i).getPrecio() * cantidades.get(i);
        }
        return subtotal;
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        return subtotal > UMBRAL_DESCUENTO ? subtotal * PORCENTAJE_DESCUENTO : 0;
    }

    /** Total final = subtotal - descuento. */
    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }

    public void mostrar() {
        System.out.println("Carrito:");
        if (productos.isEmpty()) {
            System.out.println("  (vacío)");
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.printf("  %-20s x%-3d $%9.2f%n", p.getNombre(), cantidades.get(i), p.getPrecio() * cantidades.get(i));
        }
        System.out.printf("Subtotal:          $%9.2f%n", calcularSubtotal());
        double d = calcularDescuento();
        if (d > 0) {
            System.out.printf("Descuento (10%%):  -$%9.2f%n", d);
        } else {
            System.out.printf("Descuento:         $%9.2f  (se aplica 10%% si el subtotal supera $%.0f)%n", 0.0, UMBRAL_DESCUENTO);
        }
        System.out.printf("TOTAL FINAL:       $%9.2f%n", calcularTotal());
    }
}
