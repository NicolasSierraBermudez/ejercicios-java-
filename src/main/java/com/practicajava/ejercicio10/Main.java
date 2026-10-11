package com.practicajava.ejercicio10;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 10 - Registro Académico: Búsqueda y Modificación.
 * La clase Curso incorpora buscarEstudiante(nombre) y
 * modificarNota(nombreEstudiante, nombreAsignatura, nuevaNota).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 10: BÚSQUEDA Y MODIFICACIÓN ===");

        // Datos de prueba
        Curso curso = new Curso("Programación I");
        curso.agregarEstudiante(new Estudiante("María García").agregar("Matemáticas", 8.5).agregar("Programación", 9));
        curso.agregarEstudiante(new Estudiante("Juan Pérez").agregar("Matemáticas", 5).agregar("Programación", 5.5));
        curso.agregarEstudiante(new Estudiante("Lucía Torres").agregar("Matemáticas", 7).agregar("Programación", 6.5));
        curso.mostrar();

        System.out.println("\n-- Demostración: se corrige la nota de Juan Pérez en Matemáticas a 7.5 --");
        curso.modificarNota("Juan Pérez", "Matemáticas", 7.5);
        curso.buscarEstudiante("juan pérez").mostrar();

        int opcion;
        do {
            System.out.println("\n1. Buscar estudiante  2. Modificar nota  3. Ver curso  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    Estudiante e = curso.buscarEstudiante(Entrada.leerTexto("Nombre: "));
                    if (e == null) {
                        System.out.println("No se encontró el estudiante.");
                    } else {
                        e.mostrar();
                    }
                }
                case 2 -> {
                    String est = Entrada.leerTexto("Nombre del estudiante: ");
                    String asig = Entrada.leerTexto("Asignatura: ");
                    double nota = Entrada.leerDouble("Nueva nota: ");
                    System.out.println(curso.modificarNota(est, asig, nota) ? "Nota modificada." : "No se modificó la nota.");
                }
                case 3 -> curso.mostrar();
                case 0 -> System.out.println("Fin del ejercicio 10.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
