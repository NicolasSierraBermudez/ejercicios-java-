package com.practicajava.ejercicio07;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 7 - Registro Académico: Clase Curso.
 * La clase Curso contiene un ArrayList<Estudiante> y ofrece:
 * calcularPromedioGeneral(), contarAprobados(), getMejorEstudiante()
 * y getPeorEstudiante().
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 7: CLASE CURSO ===");

        // Datos de prueba
        Curso curso = new Curso("Programación I");
        curso.agregarEstudiante(new Estudiante("María García").agregar("Matemáticas", 8.5).agregar("Física", 7).agregar("Programación", 9.5));
        curso.agregarEstudiante(new Estudiante("Juan Pérez").agregar("Matemáticas", 5).agregar("Física", 4.5).agregar("Programación", 6));
        curso.agregarEstudiante(new Estudiante("Lucía Torres").agregar("Matemáticas", 7).agregar("Física", 6.5).agregar("Programación", 8));
        curso.agregarEstudiante(new Estudiante("Pedro Ruiz").agregar("Matemáticas", 3).agregar("Física", 5).agregar("Programación", 4));

        curso.mostrarEstudiantes();
        curso.mostrarEstadisticas();

        int opcion;
        do {
            System.out.println("\n1. Agregar estudiante  2. Ver estudiantes  3. Ver estadísticas  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    Estudiante e = new Estudiante(Entrada.leerTexto("Nombre: "));
                    int n = Entrada.leerEntero("¿Cuántas asignaturas? ");
                    for (int i = 1; i <= n; i++) {
                        String asig = Entrada.leerTexto("  Asignatura " + i + ": ");
                        e.agregar(asig, Entrada.leerDouble("  Nota: "));
                    }
                    curso.agregarEstudiante(e);
                    System.out.println("Estudiante agregado: " + e);
                }
                case 2 -> curso.mostrarEstudiantes();
                case 3 -> curso.mostrarEstadisticas();
                case 0 -> System.out.println("Fin del ejercicio 7.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
