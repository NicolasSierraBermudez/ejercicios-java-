package com.practicajava.ejercicio08;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 8 - Registro Académico: Gestión de Asistencia.
 * El Estudiante tiene un atributo de faltas. El método aprobo() devuelve
 * true solo si el promedio es >= 6 Y las faltas son menores que 10.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 8: GESTIÓN DE ASISTENCIA ===");

        // Datos de prueba: casos que cubren todas las combinaciones
        Curso curso = new Curso("Programación I");
        curso.agregarEstudiante(new Estudiante("María García", 2).agregar("Matemáticas", 8.5).agregar("Programación", 9));
        curso.agregarEstudiante(new Estudiante("Juan Pérez", 12).agregar("Matemáticas", 8).agregar("Programación", 7.5));
        curso.agregarEstudiante(new Estudiante("Lucía Torres", 3).agregar("Matemáticas", 4).agregar("Programación", 5));
        curso.agregarEstudiante(new Estudiante("Pedro Ruiz", 15).agregar("Matemáticas", 3).agregar("Programación", 4.5));
        curso.mostrar();

        int opcion;
        do {
            System.out.println("\n1. Registrar falta  2. Agregar estudiante  3. Ver curso  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    Estudiante e = curso.buscarEstudiante(Entrada.leerTexto("Nombre del estudiante: "));
                    if (e == null) {
                        System.out.println("Estudiante no encontrado.");
                    } else {
                        e.registrarFalta();
                        System.out.println("Falta registrada -> " + e);
                    }
                }
                case 2 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    int faltas = Entrada.leerEntero("Faltas: ");
                    Estudiante e = new Estudiante(nombre, faltas);
                    int n = Entrada.leerEntero("¿Cuántas asignaturas? ");
                    for (int i = 1; i <= n; i++) {
                        String asig = Entrada.leerTexto("  Asignatura " + i + ": ");
                        e.agregar(asig, Entrada.leerDouble("  Nota: "));
                    }
                    curso.agregarEstudiante(e);
                    System.out.println("Agregado -> " + e);
                }
                case 3 -> curso.mostrar();
                case 0 -> System.out.println("Fin del ejercicio 8.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
