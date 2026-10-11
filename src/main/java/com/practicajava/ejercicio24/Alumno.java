package com.practicajava.ejercicio24;

/**
 * Ejercicio 24 - Alumno con nota original y nota con curva.
 */
public class Alumno {

    private final String nombre;
    private final double notaOriginal;
    private double notaFinal;

    public Alumno(String nombre, double notaOriginal) {
        if (notaOriginal < 0 || notaOriginal > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10.");
        }
        this.nombre = nombre;
        this.notaOriginal = notaOriginal;
        this.notaFinal = notaOriginal;
    }

    public void aplicarCurva(double puntos) {
        notaFinal = Math.min(10.0, notaOriginal + puntos);
    }

    public boolean aprobo() {
        return notaFinal >= 6.0;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-14s Original: %5.2f  Con curva: %5.2f  %s",
                nombre, notaOriginal, notaFinal, aprobo() ? "APROBADO" : "REPROBADO");
    }
}
