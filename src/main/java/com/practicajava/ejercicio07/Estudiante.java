package com.practicajava.ejercicio07;

import java.util.ArrayList;

/**
 * Ejercicio 7 - Estudiante con lista de asignaturas.
 */
public class Estudiante {

    private final String nombre;
    private final ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    /** Facilita crear el estudiante con varias asignaturas de una vez. */
    public Estudiante agregar(String asignatura, double nota) {
        asignaturas.add(new Asignatura(asignatura, nota));
        return this;
    }

    public double calcularPromedio() {
        if (asignaturas.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Asignatura a : asignaturas) {
            suma += a.getNotaFinal();
        }
        return suma / asignaturas.size();
    }

    public boolean aprobo() {
        return calcularPromedio() >= 6;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-16s Promedio: %5.2f  %s", nombre, calcularPromedio(), aprobo() ? "APROBADO" : "REPROBADO");
    }
}
