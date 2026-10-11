package com.practicajava.ejercicio09;

import java.util.ArrayList;

/**
 * Ejercicio 9 - Estudiante con asignaturas y faltas.
 */
public class Estudiante {

    private final String nombre;
    private final ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private final int faltas;

    public Estudiante(String nombre, int faltas) {
        this.nombre = nombre;
        this.faltas = faltas;
    }

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
        return calcularPromedio() >= 6 && faltas < 10;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFaltas() {
        return faltas;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
