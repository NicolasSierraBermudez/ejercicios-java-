package com.practicajava.util;

import java.util.Scanner;

/**
 * Utilidad de lectura por consola compartida por todos los ejercicios.
 * Se usa un único Scanner sobre System.in (que nunca se cierra) para que
 * los ejercicios puedan ejecutarse uno tras otro desde el menú principal
 * sin que se cierre la entrada estándar.
 */
public final class Entrada {

    public static final Scanner SC = new Scanner(System.in);

    private Entrada() {
    }

    /** Lee una línea de texto completa. */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return SC.hasNextLine() ? SC.nextLine().trim() : "";
    }

    /** Lee un entero; vuelve a pedirlo si el usuario escribe algo inválido. */
    public static int leerEntero(String mensaje) {
        while (true) {
            String linea = leerTexto(mensaje);
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido. Introduce un número entero.");
                if (!SC.hasNextLine() && linea.isEmpty()) {
                    return 0; // fin de la entrada: evitar bucle infinito
                }
            }
        }
    }

    /** Lee un número decimal (acepta coma o punto); vuelve a pedirlo si es inválido. */
    public static double leerDouble(String mensaje) {
        while (true) {
            String linea = leerTexto(mensaje).replace(',', '.');
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("  Valor no válido. Introduce un número (ej. 150.50).");
                if (!SC.hasNextLine() && linea.isEmpty()) {
                    return 0;
                }
            }
        }
    }

    /** Pausa hasta que el usuario pulse ENTER. */
    public static void pausa() {
        leerTexto("\nPulsa ENTER para continuar...");
    }
}
