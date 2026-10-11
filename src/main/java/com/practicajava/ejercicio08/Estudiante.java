package com.practicajava.ejercicio08;

import java.util.ArrayList;

/**
 * Ejercicio 8 - Estudiante con control de asistencia.
 * Aprueba solo si su promedio es >= 6 Y tiene menos de 10 faltas.
 */
public class Estudiante {

    public static final double NOTA_MINIMA = 6.0;
    public static final int MAX_FALTAS = 10;

    private final String nombre;
    private final ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private int faltas;

    public Estudiante(String nombre, int faltas) {
        this.nombre = nombre;
        this.faltas = Math.max(0, faltas);
    }

    public Estudiante agregar(String asignatura, double nota) {
        asignaturas.add(new Asignatura(asignatura, nota));
        return this;
    }

    public void registrarFalta() {
        faltas++;
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

    /** Condición doble: nota suficiente y asistencia suficiente. */
    public boolean aprobo() {
        return calcularPromedio() >= NOTA_MINIMA && faltas < MAX_FALTAS;
    }

    /** Explica el motivo del resultado. */
    public String getMotivo() {
        if (aprobo()) {
            return "APROBADO";
        }
        boolean porNota = calcularPromedio() < NOTA_MINIMA;
        boolean porFaltas = faltas >= MAX_FALTAS;
        if (porNota && porFaltas) {
            return "REPROBADO (nota y faltas)";
        }
        return porNota ? "REPROBADO (nota)" : "REPROBADO (faltas)";
    }

    public String getNombre() {
        return nombre;
    }

    public int getFaltas() {
        return faltas;
    }

    @Override
    public String toString() {
        return String.format("%-16s Promedio: %5.2f  Faltas: %2d  %s", nombre, calcularPromedio(), faltas, getMotivo());
    }
}
