package com.practicajava.ejercicio10;

import java.util.ArrayList;

/**
 * Ejercicio 10 - Curso con búsqueda de estudiantes y modificación de notas.
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

    /** Devuelve el estudiante con ese nombre exacto (sin distinguir mayúsculas) o null. */
    public Estudiante buscarEstudiante(String nombreBuscado) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombreBuscado.trim())) {
                return e;
            }
        }
        return null;
    }

    /**
     * Modifica la nota de una asignatura de un estudiante.
     * Devuelve true si se encontró al estudiante y la asignatura y la nota es válida (0-10).
     */
    public boolean modificarNota(String nombreEstudiante, String nombreAsignatura, double nuevaNota) {
        if (nuevaNota < 0 || nuevaNota > 10) {
            System.out.println("  La nota debe estar entre 0 y 10.");
            return false;
        }
        Estudiante e = buscarEstudiante(nombreEstudiante);
        if (e == null) {
            System.out.println("  Estudiante no encontrado.");
            return false;
        }
        Asignatura a = e.buscarAsignatura(nombreAsignatura);
        if (a == null) {
            System.out.println("  " + e.getNombre() + " no cursa la asignatura '" + nombreAsignatura + "'.");
            return false;
        }
        System.out.printf("  %s / %s: %.2f -> %.2f%n", e.getNombre(), a.getNombre(), a.getNotaFinal(), nuevaNota);
        a.setNotaFinal(nuevaNota);
        return true;
    }

    public void mostrar() {
        System.out.println("Curso: " + nombre);
        for (Estudiante e : estudiantes) {
            e.mostrar();
        }
    }
}
