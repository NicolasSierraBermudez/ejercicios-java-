package com.practicajava.ejercicio13;

import com.practicajava.util.Entrada;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * EJERCICIO 13 - Tienda Online: Herencia (Tipos de Producto).
 * Producto es la clase base. Las subclases ProductoAlimenticio
 * (fechaCaducidad) y ProductoElectronico (mesesGarantia) amplían su información.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 13: HERENCIA - TIPOS DE PRODUCTO ===");

        // Datos de prueba (las fechas se calculan desde hoy para que siempre sean coherentes)
        LocalDate hoy = LocalDate.now();
        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new ProductoElectronico(1, "Smartphone", 499.99, 24));
        catalogo.add(new ProductoElectronico(2, "Tablet", 299.00, 12));
        catalogo.add(new ProductoAlimenticio(3, "Leche 1L", 1.20, hoy.plusDays(10)));
        catalogo.add(new ProductoAlimenticio(4, "Yogur natural", 0.80, hoy.minusDays(2)));
        catalogo.add(new ProductoAlimenticio(5, "Arroz 1kg", 2.10, hoy.plusMonths(12)));
        catalogo.add(new Producto(6, "Cuaderno", 3.50));

        Carrito carrito = new Carrito();
        System.out.println("Catálogo (polimorfismo: cada producto muestra su detalle):");
        catalogo.forEach(p -> System.out.println("  " + p));

        System.out.println("\n-- Demostración: agregar Smartphone, Leche y Yogur caducado --");
        carrito.agregarProducto(catalogo.get(0));
        carrito.agregarProducto(catalogo.get(2));
        carrito.agregarProducto(catalogo.get(3));
        carrito.mostrar();

        int opcion;
        do {
            System.out.println("\n1. Ver catálogo  2. Agregar producto  3. Ver carrito  4. Ver solo electrónicos  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> catalogo.forEach(p -> System.out.println("  " + p));
                case 2 -> {
                    int codigo = Entrada.leerEntero("Código: ");
                    Producto elegido = null;
                    for (Producto p : catalogo) {
                        if (p.getCodigo() == codigo) {
                            elegido = p;
                        }
                    }
                    if (elegido == null) {
                        System.out.println("Producto no encontrado.");
                    } else if (carrito.agregarProducto(elegido)) {
                        System.out.println("Agregado: " + elegido.getNombre());
                    }
                }
                case 3 -> carrito.mostrar();
                case 4 -> {
                    for (Producto p : catalogo) {
                        if (p instanceof ProductoElectronico e) {
                            System.out.println("  " + e.getNombre() + " -> " + e.getMesesGarantia() + " meses de garantía");
                        }
                    }
                }
                case 0 -> System.out.println("Fin del ejercicio 13.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
