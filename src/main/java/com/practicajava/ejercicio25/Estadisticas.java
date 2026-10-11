package com.practicajava.ejercicio25;

import java.util.ArrayList;

/**
 * Ejercicio 25 - Cálculo de estadísticas del grupo antes y después de la curva.
 */
public final class Estadisticas {

    private Estadisticas() {
    }

    /** Media aritmética de las notas (originales o con curva). */
    public static double media(ArrayList<Alumno> alumnos, boolean conCurva) {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Alumno a : alumnos) {
            suma += conCurva ? a.getNotaFinal() : a.getNotaOriginal();
        }
        return suma / alumnos.size();
    }

    /**
     * Desviación estándar poblacional:
     * sqrt( sum( (x - media)^2 ) / n )
     */
    public static double desviacionEstandar(ArrayList<Alumno> alumnos, boolean conCurva) {
        if (alumnos.isEmpty()) {
            return 0;
        }
        double m = media(alumnos, conCurva);
        double sumaCuadrados = 0;
        for (Alumno a : alumnos) {
            double x = conCurva ? a.getNotaFinal() : a.getNotaOriginal();
            sumaCuadrados += Math.pow(x - m, 2);
        }
        return Math.sqrt(sumaCuadrados / alumnos.size());
    }

    public static int contarAprobados(ArrayList<Alumno> alumnos, boolean conCurva) {
        int c = 0;
        for (Alumno a : alumnos) {
            if (conCurva ? a.aproboConCurva() : a.aproboOriginal()) {
                c++;
            }
        }
        return c;
    }

    /** Cuántos alumnos estaban reprobados con la nota original y aprueban con la curva. */
    public static int contarRescatados(ArrayList<Alumno> alumnos) {
        int c = 0;
        for (Alumno a : alumnos) {
            if (!a.aproboOriginal() && a.aproboConCurva()) {
                c++;
            }
        }
        return c;
    }

    /** Imprime una tabla comparativa antes/después de la curva. */
    public static void mostrarInforme(ArrayList<Alumno> alumnos) {
        System.out.println("Alumnos:");
        alumnos.forEach(a -> System.out.println("  " + a));
        System.out.println("\n                      ANTES     DESPUÉS");
        System.out.printf("Media:               %6.2f    %6.2f%n", media(alumnos, false), media(alumnos, true));
        System.out.printf("Desviación estándar: %6.2f    %6.2f%n", desviacionEstandar(alumnos, false), desviacionEstandar(alumnos, true));
        System.out.printf("Aprobados:           %6d    %6d%n", contarAprobados(alumnos, false), contarAprobados(alumnos, true));
        System.out.println("Pasaron de reprobado a aprobado gracias a la curva: " + contarRescatados(alumnos));
    }
}
