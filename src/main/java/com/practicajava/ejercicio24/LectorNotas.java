package com.practicajava.ejercicio24;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Ejercicio 24 - Lectura robusta de notas con manejo de excepciones.
 * Usa Scanner.nextDouble() dentro de un try-catch: si el usuario escribe
 * texto se captura InputMismatchException, se descarta la entrada errónea
 * y se vuelve a pedir la nota.
 */
public class LectorNotas {

    private final Scanner sc;

    public LectorNotas(Scanner sc) {
        // Se fija el punto como separador decimal (ej. 7.5) para que el
        // comportamiento no dependa de la configuración regional del equipo.
        this.sc = sc.useLocale(Locale.US);
    }

    /**
     * Pide una nota entre 0 y 10 hasta que el usuario introduzca un valor válido.
     * @throws NoSuchElementException si se termina la entrada estándar.
     */
    public double leerNota(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double nota = sc.nextDouble();
                sc.nextLine(); // consumir el salto de línea pendiente
                if (nota < 0 || nota > 10) {
                    System.out.println("  Error: la nota debe estar entre 0 y 10.");
                    continue;
                }
                return nota;
            } catch (InputMismatchException e) {
                String basura = sc.nextLine(); // descartar el texto inválido
                System.out.println("  Error: '" + basura.trim() + "' no es un número válido (usa punto decimal, ej. 7.5). Inténtalo de nuevo.");
            }
        }
    }
}
