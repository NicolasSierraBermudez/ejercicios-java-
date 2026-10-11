package com.practicajava.ejercicio10;

import java.util.ArrayList;

/**
 * Ejercicio 10 - Estudiante con asignaturas consultables por nombre.
 */
public class Estudiante {

    private final String nombre;
    private final ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante agregar(String asignatura, double nota) {
        asignaturas.add(new Asignatura(asignatura, nota));
        return this;
    }

    /** Busca una asignatura del estudiante por nombre (sin distinguir mayúsculas). */
    public Asignatura buscarAsignatura(String nombreAsignatura) {
        for (Asignatura a : asignaturas) {
            if (a.getNombre().equalsIgnoreCase(nombreAsignatura)) {
                return a;
            }
        }
        return null;
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

    public void mostrar() {
        System.out.printf("%s  (promedio %.2f - %s)%n", nombre, calcularPromedio(), aprobo() ? "APROBADO" : "REPROBADO");
        for (Asignatura a : asignaturas) {
            System.out.printf("   - %-14s %5.2f%n", a.getNombre(), a.getNotaFinal());
        }
    }

    public String getNombre() {
        return nombre;
    }
}
