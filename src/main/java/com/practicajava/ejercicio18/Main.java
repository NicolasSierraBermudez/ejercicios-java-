package com.practicajava.ejercicio18;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 18 - Agenda de Contactos: Búsqueda Parcial.
 * buscarContacto(String nombre) devuelve un ArrayList<Contacto> con todas
 * las coincidencias parciales (por ejemplo, "Ju" encuentra "Juan" y "Julia").
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 18: BÚSQUEDA PARCIAL ===");

        // Datos de prueba
        Agenda agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Juan Martínez", "600111222", "juan@mail.com"));
        agenda.agregarContacto(new Contacto("Julia Romero", "600333444", "julia@mail.com"));
        agenda.agregarContacto(new Contacto("Ana López", "600555666", "ana@mail.com"));
        agenda.agregarContacto(new Contacto("Mariana Gil", "600777888", "mariana@mail.com"));
        agenda.agregarContacto(new Contacto("Pedro Ruiz", "600999000", "pedro@mail.com"));
        agenda.mostrarContactos();

        System.out.println("\n-- Demostración --");
        agenda.mostrarBusqueda("Ju");
        agenda.mostrarBusqueda("ana");
        agenda.mostrarBusqueda("xyz");

        int opcion;
        do {
            System.out.println("\n1. Buscar (parcial)  2. Agregar  3. Listar  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> agenda.mostrarBusqueda(Entrada.leerTexto("Texto a buscar: "));
                case 2 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    String tel = Entrada.leerTexto("Teléfono: ");
                    agenda.agregarContacto(new Contacto(nombre, tel, Entrada.leerTexto("Email: ")));
                    System.out.println("Contacto agregado.");
                }
                case 3 -> agenda.mostrarContactos();
                case 0 -> System.out.println("Fin del ejercicio 18.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
