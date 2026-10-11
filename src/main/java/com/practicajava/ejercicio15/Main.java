package com.practicajava.ejercicio15;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 15 - Tienda Online: Inventario Centralizado.
 * La clase Inventario mantiene un ArrayList<Producto> con su stock.
 * El Carrito consulta al Inventario para validar que haya unidades
 * disponibles y descuenta el stock al agregar productos.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 15: INVENTARIO CENTRALIZADO ===");

        // Datos de prueba
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto(1, "Laptop", 850.00, 3));
        inventario.agregarProducto(new Producto(2, "Auriculares", 45.50, 10));
        inventario.agregarProducto(new Producto(3, "Mochila", 29.90, 5));
        inventario.agregarProducto(new Producto(4, "Webcam", 60.00, 1));

        Carrito carrito = new Carrito(inventario);
        inventario.mostrar();

        System.out.println("\n-- Demostración: agregar 2 Laptops y luego pedir 5 Webcams (solo hay 1) --");
        carrito.agregarProducto(1, 2);
        carrito.agregarProducto(4, 5);
        carrito.mostrar();
        inventario.mostrar();

        int opcion;
        do {
            System.out.println("\n1. Ver inventario  2. Agregar al carrito  3. Quitar del carrito  4. Ver carrito  5. Finalizar compra  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> inventario.mostrar();
                case 2 -> {
                    int codigo = Entrada.leerEntero("Código: ");
                    int cant = Entrada.leerEntero("Cantidad: ");
                    if (carrito.agregarProducto(codigo, cant)) {
                        System.out.println("Producto agregado y stock actualizado.");
                    }
                }
                case 3 -> System.out.println(carrito.quitarProducto(Entrada.leerEntero("Código a quitar: "))
                        ? "Producto quitado; stock repuesto." : "Ese producto no está en el carrito.");
                case 4 -> carrito.mostrar();
                case 5 -> carrito.finalizarCompra();
                case 0 -> System.out.println("Fin del ejercicio 15.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
