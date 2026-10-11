package com.practicajava.ejercicio08;

import java.util.ArrayList;

/**
 * Ejercicio 8 - Curso que tiene en cuenta la asistencia al contar aprobados.
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

    public Estudiante buscarEstudiante(String nombreBuscado) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return e;
            }
        }
        return null;
    }

    public int contarAprobados() {
        int c = 0;
        for (Estudiante e : estudiantes) {
            if (e.aprobo()) {
                c++;
            }
        }
        return c;
    }

    public void mostrar() {
        System.out.println("Curso: " + nombre + " (aprueba con promedio >= " + Estudiante.NOTA_MINIMA
                + " y menos de " + Estudiante.MAX_FALTAS + " faltas)");
        for (Estudiante e : estudiantes) {
            System.out.println("  " + e);
        }
        System.out.println("Aprobados: " + contarAprobados() + " de " + estudiantes.size());
    }
}
