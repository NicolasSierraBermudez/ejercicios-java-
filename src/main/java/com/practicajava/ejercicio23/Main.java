package com.practicajava.ejercicio23;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 23 - Sistema de Notas con Curva: Sistema de Ponderaciones.
 * Cada Alumno tiene notaParcial1 (30 %), notaParcial2 (30 %) y
 * examenFinal (40 %). calcularNotaOriginal() aplica las ponderaciones
 * y sobre esa nota se aplica después la curva.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 23: SISTEMA DE PONDERACIONES ===");
        System.out.println("Ponderaciones: Parcial 1 = 30%, Parcial 2 = 30%, Examen final = 40%");

        // Datos de prueba
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Ana", 8.0, 9.0, 8.5));
        alumnos.add(new Alumno("Carlos", 5.0, 6.0, 4.5));
        alumnos.add(new Alumno("Lucía", 7.0, 6.5, 7.5));
        alumnos.add(new Alumno("Pedro", 4.0, 5.0, 5.5));
        mostrar(alumnos);

        int opcion;
        do {
            System.out.println("\n1. Agregar alumno  2. Aplicar curva (puntos)  3. Ver notas  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    double p1 = limitar(Entrada.leerDouble("Parcial 1 (0-10): "));
                    double p2 = limitar(Entrada.leerDouble("Parcial 2 (0-10): "));
                    double fin = limitar(Entrada.leerDouble("Examen final (0-10): "));
                    Alumno a = new Alumno(nombre, p1, p2, fin);
                    alumnos.add(a);
                    System.out.println("Agregado -> " + a);
                }
                case 2 -> {
                    double puntos = Entrada.leerDouble("Puntos de curva: ");
                    alumnos.forEach(a -> a.setCurva(puntos));
                    mostrar(alumnos);
                }
                case 3 -> mostrar(alumnos);
                case 0 -> System.out.println("Fin del ejercicio 23.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static double limitar(double nota) {
        return Math.max(0, Math.min(10, nota));
    }

    private static void mostrar(ArrayList<Alumno> alumnos) {
        alumnos.forEach(a -> System.out.println("  " + a));
    }
}
