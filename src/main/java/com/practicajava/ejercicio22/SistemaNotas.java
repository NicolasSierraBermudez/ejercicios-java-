package com.practicajava.ejercicio22;

import java.util.ArrayList;

/**
 * Ejercicio 22 - Sistema de notas con curva basada en el mejor alumno.
 * La curva es (10 - notaMasAlta) y se suma a todos los alumnos, de modo
 * que el mejor alumno queda exactamente con 10.
 */
public class SistemaNotas {

    private final ArrayList<Alumno> alumnos = new ArrayList<>();

    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    /** Devuelve la nota original más alta del grupo (0 si no hay alumnos). */
    public double calcularNotaMasAlta() {
        double max = 0;
        for (Alumno a : alumnos) {
            max = Math.max(max, a.getNotaOriginal());
        }
        return max;
    }

    /** Aplica la curva automática y devuelve los puntos añadidos. */
    public double aplicarCurvaMejorAlumno() {
        double curva = 10.0 - calcularNotaMasAlta();
        for (Alumno a : alumnos) {
            a.aplicarCurva(curva);
        }
        return curva;
    }

    public void mostrar() {
        for (Alumno a : alumnos) {
            System.out.println("  " + a);
        }
    }

    public boolean estaVacio() {
        return alumnos.isEmpty();
    }
}
