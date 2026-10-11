package com.practicajava.ejercicio22;

/**
 * Ejercicio 22 - Alumno con nota original y nota con curva.
 */
public class Alumno {

    private final String nombre;
    private final double notaOriginal;
    private double notaFinal;

    public Alumno(String nombre, double notaOriginal) {
        this.nombre = nombre;
        this.notaOriginal = notaOriginal;
        this.notaFinal = notaOriginal;
    }

    /** Suma una cantidad fija de puntos a la nota original (máximo 10). */
    public void aplicarCurva(double puntos) {
        notaFinal = Math.min(10.0, notaOriginal + puntos);
    }

    public boolean aprobo() {
        return notaFinal >= 6.0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaOriginal() {
        return notaOriginal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return String.format("%-14s Original: %5.2f  Con curva: %5.2f  %s",
                nombre, notaOriginal, notaFinal, aprobo() ? "APROBADO" : "REPROBADO");
    }
}
