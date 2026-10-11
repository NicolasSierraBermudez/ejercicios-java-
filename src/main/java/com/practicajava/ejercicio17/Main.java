package com.practicajava.ejercicio17;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 17 - Agenda de Contactos: Validación de Datos.
 * Antes de guardar un contacto se valida que el teléfono contenga solo
 * números y tenga 9 dígitos, y que el email contenga "@" y ".".
 * En el modo interactivo se vuelve a pedir el dato hasta que sea válido.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 17: VALIDACIÓN DE DATOS ===");

        Agenda agenda = new Agenda();

        // Datos de prueba: válidos e inválidos
        System.out.println("-- Demostración de validaciones --");
        System.out.println(agenda.agregarContacto("Ana López", "600111222", "ana@mail.com"));
        System.out.println(agenda.agregarContacto("Carlos Pérez", "60033", "carlos@mail.com"));
        System.out.println(agenda.agregarContacto("Lucía Torres", "60055566A", "lucia@mail.com"));
        System.out.println(agenda.agregarContacto("Pedro Ruiz", "600777888", "pedro.mail.com"));
        System.out.println(agenda.agregarContacto("Marta Gil", "600999000", "marta@mailcom"));
        System.out.println(agenda.agregarContacto("Jorge Díaz", "611222333", "jorge@empresa.es"));
        agenda.mostrarContactos();

        int opcion;
        do {
            System.out.println("\n1. Agregar contacto (con validación)  2. Listar  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    String tel = Entrada.leerTexto("Teléfono (9 dígitos): ");
                    while (!Contacto.validarTelefono(tel)) {
                        tel = Entrada.leerTexto("  Teléfono inválido. Debe tener 9 dígitos numéricos: ");
                        if (tel.isEmpty() && !Entrada.SC.hasNextLine()) {
                            return;
                        }
                    }
                    String email = Entrada.leerTexto("Email: ");
                    while (!Contacto.validarEmail(email)) {
                        email = Entrada.leerTexto("  Email inválido. Debe contener '@' y '.': ");
                        if (email.isEmpty() && !Entrada.SC.hasNextLine()) {
                            return;
                        }
                    }
                    System.out.println(agenda.agregarContacto(nombre, tel, email));
                }
                case 2 -> agenda.mostrarContactos();
                case 0 -> System.out.println("Fin del ejercicio 17.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
