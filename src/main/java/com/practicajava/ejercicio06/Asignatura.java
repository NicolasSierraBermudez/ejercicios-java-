package com.practicajava.ejercicio06;

/**
 * Ejercicio 6 - Asignatura con nombre y nota final (escala 0 a 10).
 */
public class Asignatura {

    private final String nombre;
    private double notaFinal;

    public Asignatura(String nombre, double notaFinal) {
        this.nombre = nombre;
        setNotaFinal(notaFinal);
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    /** Asegura que la nota quede siempre entre 0 y 10. */
    public final void setNotaFinal(double notaFinal) {
        this.notaFinal = Math.max(0, Math.min(10, notaFinal));
    }

    @Override
    public String toString() {
        return String.format("%-14s %5.2f", nombre, notaFinal);
    }
}
