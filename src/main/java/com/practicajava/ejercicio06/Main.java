package com.practicajava.ejercicio06;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 6 - Registro Académico: Asignaturas Múltiples.
 * El Estudiante ya no tiene una sola nota: tiene un ArrayList<Asignatura>
 * (nombre y notaFinal). Su promedio es la media de todas sus asignaturas.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 6: ASIGNATURAS MÚLTIPLES ===");

        // Datos de prueba
        Estudiante est = new Estudiante("María García");
        est.agregarAsignatura(new Asignatura("Matemáticas", 8.5));
        est.agregarAsignatura(new Asignatura("Física", 6.0));
        est.agregarAsignatura(new Asignatura("Programación", 9.5));
        est.mostrarBoletin();

        int opcion;
        do {
            System.out.println("\n1. Agregar asignatura  2. Ver boletín  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre de la asignatura: ");
                    double nota = Entrada.leerDouble("Nota final (0-10): ");
                    est.agregarAsignatura(new Asignatura(nombre, nota));
                    System.out.println("Asignatura agregada.");
                }
                case 2 -> est.mostrarBoletin();
                case 0 -> System.out.println("Fin del ejercicio 6.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
