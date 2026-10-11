package com.practicajava.ejercicio07;

import java.util.ArrayList;

/**
 * Ejercicio 7 - Clase Curso.
 * Agrupa estudiantes y calcula estadísticas del grupo.
 */
public class Curso {

    private final String nombre;
    private final ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    /** Media de los promedios de todos los estudiantes. */
    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.calcularPromedio();
        }
        return suma / estudiantes.size();
    }

    public int contarAprobados() {
        int contador = 0;
        for (Estudiante e : estudiantes) {
            if (e.aprobo()) {
                contador++;
            }
        }
        return contador;
    }

    public Estudiante getMejorEstudiante() {
        Estudiante mejor = null;
        for (Estudiante e : estudiantes) {
            if (mejor == null || e.calcularPromedio() > mejor.calcularPromedio()) {
                mejor = e;
            }
        }
        return mejor;
    }

    public Estudiante getPeorEstudiante() {
        Estudiante peor = null;
        for (Estudiante e : estudiantes) {
            if (peor == null || e.calcularPromedio() < peor.calcularPromedio()) {
                peor = e;
            }
        }
        return peor;
    }

    public void mostrarEstudiantes() {
        System.out.println("Curso: " + nombre);
        for (Estudiante e : estudiantes) {
            System.out.println("  " + e);
        }
    }

    public void mostrarEstadisticas() {
        System.out.printf("Promedio general: %.2f%n", calcularPromedioGeneral());
        System.out.println("Aprobados: " + contarAprobados() + " de " + estudiantes.size());
        if (!estudiantes.isEmpty()) {
            System.out.println("Mejor estudiante: " + getMejorEstudiante());
            System.out.println("Peor estudiante:  " + getPeorEstudiante());
        }
    }
}
