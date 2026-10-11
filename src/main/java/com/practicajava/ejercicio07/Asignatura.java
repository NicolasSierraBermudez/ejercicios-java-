package com.practicajava.ejercicio07;

/**
 * Ejercicio 7 - Asignatura con nombre y nota final.
 */
public class Asignatura {

    private final String nombre;
    private final double notaFinal;

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
}
