package com.practicajava.ejercicio06;

import java.util.ArrayList;

/**
 * Ejercicio 6 - Estudiante con varias asignaturas.
 * El promedio se calcula como la media de las notas finales de todas sus asignaturas.
 */
public class Estudiante {

    private final String nombre;
    private final ArrayList<Asignatura> asignaturas = new ArrayList<>();

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAsignatura(Asignatura a) {
        asignaturas.add(a);
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

    public void mostrarBoletin() {
        System.out.println("Boletín de " + nombre + ":");
        for (Asignatura a : asignaturas) {
            System.out.println("  " + a);
        }
        System.out.printf("  Promedio: %.2f -> %s%n", calcularPromedio(), aprobo() ? "APROBADO" : "REPROBADO");
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
