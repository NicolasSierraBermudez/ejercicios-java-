package com.practicajava.ejercicio09;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Ejercicio 9 - Curso con generación de reporte en archivo de texto.
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
        int c = 0;
        for (Estudiante e : estudiantes) {
            if (e.aprobo()) {
                c++;
            }
        }
        return c;
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

    /** Construye el texto del reporte (se usa tanto para pantalla como para archivo). */
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("==============================================\n");
        sb.append(" REPORTE DEL CURSO: ").append(nombre).append('\n');
        sb.append(" Fecha: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append('\n');
        sb.append("==============================================\n");
        for (Estudiante e : estudiantes) {
            sb.append(String.format("%-18s Promedio: %5.2f  Faltas: %2d  %s%n",
                    e.getNombre(), e.calcularPromedio(), e.getFaltas(), e.aprobo() ? "APROBADO" : "REPROBADO"));
            for (Asignatura a : e.getAsignaturas()) {
                sb.append(String.format("     - %-14s %5.2f%n", a.getNombre(), a.getNotaFinal()));
            }
        }
        sb.append("----------------------------------------------\n");
        sb.append("ESTADÍSTICAS\n");
        sb.append(String.format("Total de estudiantes: %d%n", estudiantes.size()));
        sb.append(String.format("Promedio general:     %.2f%n", calcularPromedioGeneral()));
        sb.append(String.format("Aprobados:            %d%n", contarAprobados()));
        sb.append(String.format("Reprobados:           %d%n", estudiantes.size() - contarAprobados()));
        Estudiante mejor = getMejorEstudiante();
        if (mejor != null) {
            sb.append(String.format("Mejor estudiante:     %s (%.2f)%n", mejor.getNombre(), mejor.calcularPromedio()));
        }
        return sb.toString();
    }

    /**
     * Guarda el reporte en un archivo .txt. Devuelve true si se escribió correctamente.
     */
    public boolean guardarReporte(String nombreArchivo) {
        if (!nombreArchivo.toLowerCase().endsWith(".txt")) {
            nombreArchivo += ".txt";
        }
        Path ruta = Paths.get(nombreArchivo).toAbsolutePath();
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(ruta, StandardCharsets.UTF_8))) {
            pw.print(generarReporte());
            System.out.println("Reporte guardado en: " + ruta);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el reporte: " + e.getMessage());
            return false;
        }
    }
}
