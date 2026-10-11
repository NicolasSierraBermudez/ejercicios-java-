package com.practicajava.ejercicio25;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 25 - Sistema de Notas con Curva: Estadísticas Avanzadas.
 * Después de aplicar la curva se calculan la nueva media, la desviación
 * estándar y cuántos alumnos pasaron de reprobado a aprobado.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 25: ESTADÍSTICAS AVANZADAS ===");

        // Datos de prueba
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Ana", 8.8));
        alumnos.add(new Alumno("Carlos", 5.4));
        alumnos.add(new Alumno("Lucía", 7.1));
        alumnos.add(new Alumno("Pedro", 4.2));
        alumnos.add(new Alumno("Sofía", 5.9));
        alumnos.add(new Alumno("Jorge", 3.5));
        alumnos.add(new Alumno("Marta", 6.5));

        // Curva automática basada en el mejor alumno (10 - nota más alta)
        double max = 0;
        for (Alumno a : alumnos) {
            max = Math.max(max, a.getNotaOriginal());
        }
        double curva = 10 - max;
        alumnos.forEach(a -> a.aplicarCurva(curva));
        System.out.printf("Curva automática aplicada: +%.2f puntos (mejor nota %.2f)%n%n", curva, max);
        Estadisticas.mostrarInforme(alumnos);

        int opcion;
        do {
            System.out.println("\n1. Aplicar curva manual (puntos)  2. Agregar alumno  3. Ver informe  0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> {
                    double puntos = Entrada.leerDouble("Puntos de curva: ");
                    alumnos.forEach(a -> a.aplicarCurva(puntos));
                    Estadisticas.mostrarInforme(alumnos);
                }
                case 2 -> {
                    String nombre = Entrada.leerTexto("Nombre: ");
                    double nota = Math.max(0, Math.min(10, Entrada.leerDouble("Nota original (0-10): ")));
                    alumnos.add(new Alumno(nombre, nota));
                    System.out.println("Alumno agregado (sin curva hasta que apliques una).");
                }
                case 3 -> Estadisticas.mostrarInforme(alumnos);
                case 0 -> System.out.println("Fin del ejercicio 25.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
