package com.practicajava.ejercicio12;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 12 - Tienda Online: Sistema de Descuentos.
 * Carrito.calcularTotal() aplica un 10 % de descuento si el subtotal es
 * mayor a $1000. Se muestran subtotal, descuento aplicado y total final.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 12: SISTEMA DE DESCUENTOS ===");

        // Datos de prueba
        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto(1, "Laptop", 850.00));
        catalogo.add(new Producto(2, "Monitor 27\"", 260.00));
        catalogo.add(new Producto(3, "Teclado", 35.00));
        catalogo.add(new Producto(4, "Ratón", 20.00));

        Carrito carrito = new Carrito();
        System.out.println("-- Demostración 1: compra menor a $1000 (sin descuento) --");
        carrito.agregarProducto(catalogo.get(2), 2);
        carrito.agregarProducto(catalogo.get(3), 1);
        carrito.mostrar();

        System.out.println("\n-- Demostración 2: compra mayor a $1000 (con 10% de descuento) --");
        carrito.agregarProducto(catalogo.get(0), 1);
        carrito.agregarProducto(catalogo.get(1), 1);
        carrito.mostrar();
        carrito.vaciar();
        System.out.println("(El carrito se vacía para que lo uses tú)");

        int opcion;
        do {
            System.out.println("\n1. Ver catálogo  2. Agregar producto  3. Ver carrito  4. Vaciar carrito  0. Salir");
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
                    } else {
                        int cant = Entrada.leerEntero("Cantidad: ");
                        carrito.agregarProducto(elegido, cant);
                        System.out.println(cant > 0 ? "Producto agregado." : "Cantidad no válida.");
                    }
                }
                case 3 -> carrito.mostrar();
                case 4 -> {
                    carrito.vaciar();
                    System.out.println("Carrito vaciado.");
                }
                case 0 -> System.out.println("Fin del ejercicio 12.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
