package com.practicajava.ejercicio10;

/**
 * Ejercicio 10 - Asignatura cuya nota puede modificarse.
 */
public class Asignatura {

    private final String nombre;
    private double notaFinal;

    public Asignatura(String nombre, double notaFinal) {
        this.nombre = nombre;
        this.notaFinal = notaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
