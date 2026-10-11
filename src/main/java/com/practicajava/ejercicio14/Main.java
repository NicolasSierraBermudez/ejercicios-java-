package com.practicajava.ejercicio14;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 14 - Tienda Online: Gestión de Clientes.
 * Se crea la clase Cliente (nombre, email) y el Carrito queda asociado
 * a un Cliente. Al iniciar se simula un "login" pidiendo el email.
 * Si el email no existe, se ofrece registrar un cliente nuevo.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 14: GESTIÓN DE CLIENTES ===");

        // Datos de prueba
        ArrayList<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto(1, "Laptop", 850.00));
        catalogo.add(new Producto(2, "Auriculares", 45.50));
        catalogo.add(new Producto(3, "Mochila", 29.90));

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Ana López", "ana@mail.com"));
        clientes.add(new Cliente("Carlos Pérez", "carlos@mail.com"));
        // Ana ya tenía un producto en su carrito
        clientes.get(0).getCarrito().agregarProducto(catalogo.get(2));

        System.out.println("Clientes registrados (datos de prueba):");
        clientes.forEach(c -> System.out.println("  " + c));

        while (true) {
            String email = Entrada.leerTexto("\nLogin - introduce tu email (o 'salir'): ");
            if (email.isEmpty() || email.equalsIgnoreCase("salir")) {
                System.out.println("Fin del ejercicio 14.");
                return;
            }
            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getEmail().equalsIgnoreCase(email)) {
                    cliente = c;
                }
            }
            if (cliente == null) {
                String resp = Entrada.leerTexto("Email no registrado. ¿Deseas registrarte? (s/n): ");
                if (!resp.equalsIgnoreCase("s")) {
                    continue;
                }
                cliente = new Cliente(Entrada.leerTexto("Tu nombre: "), email);
                clientes.add(cliente);
                System.out.println("Cliente registrado.");
            }
            System.out.println("Bienvenido/a, " + cliente.getNombre());
            int opcion;
            do {
                System.out.println("\n1. Ver catálogo  2. Agregar al carrito  3. Ver mi carrito  0. Cerrar sesión");
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
                            cliente.getCarrito().agregarProducto(elegido);
                            System.out.println("Agregado: " + elegido.getNombre());
                        }
                    }
                    case 3 -> cliente.getCarrito().mostrar();
                    case 0 -> System.out.println("Sesión cerrada.");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}
