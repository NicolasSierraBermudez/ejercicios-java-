package com.practicajava.ejercicio11;

import com.practicajava.util.Entrada;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * EJERCICIO 11 - Tienda Online: Categorías de Productos.
 * El Producto tiene un atributo "categoria" y el main permite filtrar el
 * catálogo por categoría antes de agregar productos al carrito.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 11: CATEGORÍAS DE PRODUCTOS ===");

        // Datos de prueba
        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto(1, "Laptop", 850.00, "Electrónica"));
        catalogo.add(new Producto(2, "Auriculares", 45.50, "Electrónica"));
        catalogo.add(new Producto(3, "Camiseta", 15.99, "Ropa"));
        catalogo.add(new Producto(4, "Pantalón vaquero", 39.90, "Ropa"));
        catalogo.add(new Producto(5, "Café 1kg", 12.30, "Alimentos"));
        catalogo.add(new Producto(6, "Chocolate", 3.50, "Alimentos"));
        catalogo.add(new Producto(7, "Novela", 18.00, "Libros"));

        Carrito carrito = new Carrito();

        System.out.println("-- Demostración: filtrar 'Ropa' --");
        mostrarFiltrado(catalogo, "Ropa");

        int opcion;
        do {
            System.out.println("\n1. Ver catálogo completo  2. Filtrar por categoría y agregar  3. Ver carrito  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> catalogo.forEach(p -> System.out.println("  " + p));
                case 2 -> {
                    LinkedHashSet<String> categorias = new LinkedHashSet<>();
                    catalogo.forEach(p -> categorias.add(p.getCategoria()));
                    System.out.println("Categorías disponibles: " + categorias);
                    String cat = Entrada.leerTexto("Categoría: ");
                    ArrayList<Producto> filtrados = mostrarFiltrado(catalogo, cat);
                    if (filtrados.isEmpty()) {
                        break;
                    }
                    int codigo = Entrada.leerEntero("Código del producto a agregar (0 = ninguno): ");
                    Producto elegido = null;
                    for (Producto p : filtrados) {
                        if (p.getCodigo() == codigo) {
                            elegido = p;
                        }
                    }
                    if (elegido != null) {
                        carrito.agregarProducto(elegido);
                        System.out.println("Agregado: " + elegido.getNombre());
                    } else if (codigo != 0) {
                        System.out.println("Ese código no pertenece a la categoría filtrada.");
                    }
                }
                case 3 -> carrito.mostrar();
                case 0 -> System.out.println("Fin del ejercicio 11.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /** Muestra y devuelve los productos de la categoría indicada. */
    private static ArrayList<Producto> mostrarFiltrado(ArrayList<Producto> catalogo, String categoria) {
        ArrayList<Producto> res = new ArrayList<>();
        for (Producto p : catalogo) {
            if (p.getCategoria().equalsIgnoreCase(categoria.trim())) {
                res.add(p);
                System.out.println("  " + p);
            }
        }
        if (res.isEmpty()) {
            System.out.println("  No hay productos en la categoría '" + categoria + "'.");
        }
        return res;
    }
}
