package com.practicajava.ejercicio19;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 19 - Agenda de Contactos: Grupos de Contactos.
 * Cada Contacto tiene un atributo grupo ("Familia", "Trabajo", "Amigos")
 * y la Agenda ofrece mostrarContactosPorGrupo(String grupo).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 19: GRUPOS DE CONTACTOS ===");

        // Datos de prueba
        Agenda agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Mamá", "600111222", "mama@mail.com", "Familia"));
        agenda.agregarContacto(new Contacto("Hermano Luis", "600222333", "luis@mail.com", "Familia"));
        agenda.agregarContacto(new Contacto("Jefa Marta", "611000111", "marta@empresa.es", "Trabajo"));
        agenda.agregarContacto(new Contacto("Compañero Raúl", "611222333", "raul@empresa.es", "Trabajo"));
        agenda.agregarContacto(new Contacto("Sofía", "622333444", "sofia@mail.com", "Amigos"));
        agenda.mostrarTodosAgrupados();

        int opcion;
        do {
            System.out.println("\n1. Ver contactos por grupo  2. Agregar contacto  3. Cambiar grupo  4. Ver todos agrupados  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> agenda.mostrarContactosPorGrupo(Entrada.leerTexto("Grupo (Familia/Trabajo/Amigos): "));
                case 2 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    String tel = Entrada.leerTexto("Teléfono: ");
                    String email = Entrada.leerTexto("Email: ");
                    String grupo = Entrada.leerTexto("Grupo (Familia/Trabajo/Amigos): ");
                    if (Contacto.normalizarGrupo(grupo) == null) {
                        System.out.println("Grupo no reconocido; se asigna 'Amigos'.");
                    }
                    agenda.agregarContacto(new Contacto(nombre, tel, email, grupo));
                    System.out.println("Contacto agregado.");
                }
                case 3 -> {
                    Contacto c = agenda.buscarContacto(Entrada.leerTexto("Nombre del contacto: "));
                    if (c == null) {
                        System.out.println("No encontrado.");
                    } else {
                        c.setGrupo(Entrada.leerTexto("Nuevo grupo (Familia/Trabajo/Amigos): "));
                        System.out.println("Actualizado: " + c);
                    }
                }
                case 4 -> agenda.mostrarTodosAgrupados();
                case 0 -> System.out.println("Fin del ejercicio 19.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
