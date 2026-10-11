package com.practicajava.ejercicio09;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 9 - Registro Académico: Guardar Reporte en Archivo.
 * La clase Curso incluye guardarReporte(nombreArchivo), que genera un .txt
 * con la lista de alumnos, sus promedios y las estadísticas del curso.
 * El archivo se crea en la carpeta desde la que se ejecuta el programa
 * (en NetBeans, la carpeta raíz del proyecto).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 9: GUARDAR REPORTE EN ARCHIVO ===");

        // Datos de prueba
        Curso curso = new Curso("Programación I");
        curso.agregarEstudiante(new Estudiante("María García", 2).agregar("Matemáticas", 8.5).agregar("Programación", 9));
        curso.agregarEstudiante(new Estudiante("Juan Pérez", 12).agregar("Matemáticas", 8).agregar("Programación", 7.5));
        curso.agregarEstudiante(new Estudiante("Lucía Torres", 3).agregar("Matemáticas", 6).agregar("Programación", 7));
        curso.agregarEstudiante(new Estudiante("Pedro Ruiz", 5).agregar("Matemáticas", 3).agregar("Programación", 4.5));

        int opcion;
        do {
            System.out.println("\n1. Ver reporte en pantalla  2. Guardar reporte en archivo  3. Agregar estudiante  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> System.out.print(curso.generarReporte());
                case 2 -> {
                    String archivo = Entrada.leerTexto("Nombre del archivo [reporte_curso.txt]: ");
                    curso.guardarReporte(archivo.isEmpty() ? "reporte_curso.txt" : archivo);
                }
                case 3 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    Estudiante e = new Estudiante(nombre, Entrada.leerEntero("Faltas: "));
                    int n = Entrada.leerEntero("¿Cuántas asignaturas? ");
                    for (int i = 1; i <= n; i++) {
                        String asig = Entrada.leerTexto("  Asignatura " + i + ": ");
                        e.agregar(asig, Entrada.leerDouble("  Nota: "));
                    }
                    curso.agregarEstudiante(e);
                    System.out.println("Estudiante agregado.");
                }
                case 0 -> System.out.println("Fin del ejercicio 9.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
