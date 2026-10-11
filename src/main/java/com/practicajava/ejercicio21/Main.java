package com.practicajava.ejercicio21;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 21 - Sistema de Notas con Curva: Curva Porcentual.
 * aplicarCurvaPorcentual(porcentaje) incrementa la nota de cada alumno
 * en ese porcentaje, sin que ninguna nota supere 10.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 21: CURVA PORCENTUAL ===");

        // Datos de prueba
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Ana", 9.5));
        alumnos.add(new Alumno("Carlos", 5.5));
        alumnos.add(new Alumno("Lucía", 7.0));
        alumnos.add(new Alumno("Pedro", 4.8));
        alumnos.add(new Alumno("Sofía", 8.2));

        System.out.println("-- Demostración: curva del 10% (Ana no puede pasar de 10) --");
        aplicarCurva(alumnos, 10);
        mostrar(alumnos);

        int opcion;
        do {
            System.out.println("\n1. Aplicar curva porcentual  2. Quitar curva  3. Agregar alumno  4. Ver notas  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    double pct = Entrada.leerDouble("Porcentaje de curva (ej. 15): ");
                    if (pct < 0) {
                        System.out.println("El porcentaje no puede ser negativo.");
                    } else {
                        aplicarCurva(alumnos, pct);
                        mostrar(alumnos);
                    }
                }
                case 2 -> {
                    alumnos.forEach(Alumno::quitarCurva);
                    mostrar(alumnos);
                }
                case 3 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    double nota = Entrada.leerDouble("Nota (0-10): ");
                    alumnos.add(new Alumno(nombre, Math.max(0, Math.min(10, nota))));
                    System.out.println("Alumno agregado.");
                }
                case 4 -> mostrar(alumnos);
                case 0 -> System.out.println("Fin del ejercicio 21.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void aplicarCurva(ArrayList<Alumno> alumnos, double porcentaje) {
        for (Alumno a : alumnos) {
            a.aplicarCurvaPorcentual(porcentaje);
        }
        System.out.printf("Curva del %.1f%% aplicada.%n", porcentaje);
    }

    private static void mostrar(ArrayList<Alumno> alumnos) {
        alumnos.forEach(a -> System.out.println("  " + a));
    }
}
