package com.practicajava.ejercicio16;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 16 - Agenda de Contactos: Usar ArrayList.
 * Se reemplaza el array fijo de 20 contactos de la clase Agenda por un
 * ArrayList<Contacto>, eliminando el límite de capacidad.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 16: AGENDA CON ARRAYLIST ===");

        // Datos de prueba: 25 contactos (más de los 20 que permitía el array fijo)
        Agenda agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Ana López", "600111222", "ana@mail.com"));
        agenda.agregarContacto(new Contacto("Carlos Pérez", "600333444", "carlos@mail.com"));
        agenda.agregarContacto(new Contacto("Lucía Torres", "600555666", "lucia@mail.com"));
        for (int i = 4; i <= 25; i++) {
            agenda.agregarContacto(new Contacto("Contacto " + i, String.format("6%08d", i), "contacto" + i + "@mail.com"));
        }
        System.out.println("Se agregaron " + agenda.getCantidad() + " contactos (el array antiguo solo admitía 20).");
        for (int i = 4; i <= 25; i++) {
            agenda.eliminarContacto("Contacto " + i);
        }
        System.out.println("Se eliminaron los contactos de prueba 4..25 sin dejar huecos.");
        agenda.mostrarContactos();

        int opcion;
        do {
            System.out.println("\n1. Agregar  2. Buscar  3. Eliminar  4. Listar  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    String tel = Entrada.leerTexto("Teléfono: ");
                    String email = Entrada.leerTexto("Email: ");
                    System.out.println(agenda.agregarContacto(new Contacto(nombre, tel, email))
                            ? "Contacto agregado." : "Ya existe un contacto con ese nombre.");
                }
                case 2 -> {
                    Contacto c = agenda.buscarContacto(Entrada.leerTexto("Nombre: "));
                    System.out.println(c != null ? c : "No encontrado.");
                }
                case 3 -> System.out.println(agenda.eliminarContacto(Entrada.leerTexto("Nombre: "))
                        ? "Contacto eliminado." : "No encontrado.");
                case 4 -> agenda.mostrarContactos();
                case 0 -> System.out.println("Fin del ejercicio 16.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
