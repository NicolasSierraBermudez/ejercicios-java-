package com.practicajava.ejercicio24;

import com.practicajava.util.Entrada;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * EJERCICIO 24 - Sistema de Notas con Curva: Manejo de Excepciones.
 * Al pedir las notas se usa try-catch para capturar InputMismatchException:
 * si el usuario escribe texto en lugar de un número, el programa no se
 * detiene, muestra un aviso y vuelve a pedir la nota.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 24: MANEJO DE EXCEPCIONES ===");

        // Demostración con una entrada simulada que contiene errores
        System.out.println("-- Demostración con entrada simulada: \"abc\", \"15\", \"siete\", \"7.5\" --");
        Scanner simulado = new Scanner("abc\n15\nsiete\n7.5\n");
        double notaDemo = new LectorNotas(simulado).leerNota("Nota de prueba: ");
        System.out.println("\nNota aceptada finalmente: " + notaDemo);

        // Datos de prueba
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Ana", 8.0));
        alumnos.add(new Alumno("Carlos", 5.2));
        alumnos.add(new Alumno("Lucía", 6.8));

        // Ejemplo de excepción propia del modelo
        try {
            alumnos.add(new Alumno("Error", 12));
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada al crear alumno con nota 12: " + e.getMessage());
        }

        LectorNotas lector = new LectorNotas(Entrada.SC);
        int opcion;
        do {
            System.out.println("\n1. Agregar alumno (prueba a escribir texto en la nota)  2. Aplicar curva  3. Ver notas  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            try {
                switch (opcion) {
                    case 1 -> {
                        String nombre = Entrada.leerTexto("Nombre: ");
                        alumnos.add(new Alumno(nombre, lector.leerNota("Nota (0-10): ")));
                        System.out.println("Alumno agregado.");
                    }
                    case 2 -> {
                        double puntos = lector.leerNota("Puntos de curva (0-10): ");
                        alumnos.forEach(a -> a.aplicarCurva(puntos));
                        alumnos.forEach(a -> System.out.println("  " + a));
                    }
                    case 3 -> alumnos.forEach(a -> System.out.println("  " + a));
                    case 0 -> System.out.println("Fin del ejercicio 24.");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NoSuchElementException e) {
                // InputMismatchException ya se gestiona dentro de LectorNotas;
                // aquí solo llega si se cierra la entrada estándar.
                System.out.println("Entrada finalizada inesperadamente.");
                return;
            }
        } while (opcion != 0);
    }
}
