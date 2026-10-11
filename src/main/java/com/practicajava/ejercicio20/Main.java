package com.practicajava.ejercicio20;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 20 - Agenda de Contactos: Guardar y Cargar Agenda.
 * La Agenda incorpora guardarEnArchivo() y cargarDesdeArchivo() usando un
 * archivo de texto simple ("agenda.txt", en la carpeta desde la que se
 * ejecuta el programa; en NetBeans, la raíz del proyecto).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 20: GUARDAR Y CARGAR AGENDA ===");

        Agenda agenda = new Agenda("agenda.txt");

        // Datos de prueba: se guardan, se vacía la memoria y se vuelven a cargar
        agenda.agregarContacto(new Contacto("Ana López", "600111222", "ana@mail.com", "Amigos"));
        agenda.agregarContacto(new Contacto("Carlos Pérez", "611333444", "carlos@empresa.es", "Trabajo"));
        agenda.agregarContacto(new Contacto("Mamá", "600555666", "mama@mail.com", "Familia"));
        System.out.println("-- Demostración: guardar, vaciar memoria y cargar --");
        agenda.guardarEnArchivo();
        agenda.vaciar();
        System.out.println("Memoria vaciada. Contactos en memoria: " + agenda.getCantidad());
        agenda.cargarDesdeArchivo();
        agenda.mostrarContactos();

        int opcion;
        do {
            System.out.println("\n1. Agregar  2. Eliminar  3. Listar  4. Guardar en archivo  5. Cargar desde archivo  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    String tel = Entrada.leerTexto("Teléfono: ");
                    String email = Entrada.leerTexto("Email: ");
                    agenda.agregarContacto(new Contacto(nombre, tel, email, Entrada.leerTexto("Grupo: ")));
                    System.out.println("Contacto agregado (recuerda guardar).");
                }
                case 2 -> System.out.println(agenda.eliminarContacto(Entrada.leerTexto("Nombre: "))
                        ? "Eliminado (recuerda guardar)." : "No encontrado.");
                case 3 -> agenda.mostrarContactos();
                case 4 -> agenda.guardarEnArchivo();
                case 5 -> agenda.cargarDesdeArchivo();
                case 0 -> {
                    String r = Entrada.leerTexto("¿Guardar antes de salir? (s/n): ");
                    if (r.equalsIgnoreCase("s")) {
                        agenda.guardarEnArchivo();
                    }
                    System.out.println("Fin del ejercicio 20.");
                }
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
