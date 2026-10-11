package com.practicajava.ejercicio22;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 22 - Sistema de Notas con Curva: Curva Basada en el Mejor Alumno.
 * El programa calcula la nota más alta y aplica automáticamente una curva
 * de (10 - notaMasAlta) puntos a todos los alumnos.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 22: CURVA BASADA EN EL MEJOR ALUMNO ===");

        // Datos de prueba
        SistemaNotas sistema = new SistemaNotas();
        sistema.agregarAlumno(new Alumno("Ana", 8.5));
        sistema.agregarAlumno(new Alumno("Carlos", 5.0));
        sistema.agregarAlumno(new Alumno("Lucía", 7.2));
        sistema.agregarAlumno(new Alumno("Pedro", 4.3));
        sistema.agregarAlumno(new Alumno("Sofía", 6.1));

        System.out.printf("Nota más alta: %.2f -> curva = 10 - %.2f%n", sistema.calcularNotaMasAlta(), sistema.calcularNotaMasAlta());
        double curva = sistema.aplicarCurvaMejorAlumno();
        System.out.printf("Curva aplicada: +%.2f puntos%n", curva);
        sistema.mostrar();

        int opcion;
        do {
            System.out.println("\n1. Agregar alumno  2. Recalcular y aplicar curva  3. Ver notas  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    double nota = Math.max(0, Math.min(10, Entrada.leerDouble("Nota (0-10): ")));
                    sistema.agregarAlumno(new Alumno(nombre, nota));
                    System.out.println("Alumno agregado. Usa la opción 2 para recalcular la curva.");
                }
                case 2 -> {
                    double c = sistema.aplicarCurvaMejorAlumno();
                    System.out.printf("Nota más alta: %.2f  Curva aplicada: +%.2f%n", sistema.calcularNotaMasAlta(), c);
                    sistema.mostrar();
                }
                case 3 -> sistema.mostrar();
                case 0 -> System.out.println("Fin del ejercicio 22.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
