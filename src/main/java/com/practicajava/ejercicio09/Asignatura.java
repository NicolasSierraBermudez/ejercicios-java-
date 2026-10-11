package com.practicajava.ejercicio09;

/**
 * Ejercicio 9 - Asignatura con nombre y nota final.
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
