package com.practicajava.ejercicio23;

/**
 * Ejercicio 23 - Alumno con sistema de ponderaciones.
 * Parcial 1 = 30 %, Parcial 2 = 30 %, Examen final = 40 %.
 */
public class Alumno {

    public static final double PESO_PARCIAL1 = 0.30;
    public static final double PESO_PARCIAL2 = 0.30;
    public static final double PESO_FINAL = 0.40;

    private final String nombre;
    private final double notaParcial1;
    private final double notaParcial2;
    private final double examenFinal;
    private double curva; // puntos añadidos por la curva

    public Alumno(String nombre, double notaParcial1, double notaParcial2, double examenFinal) {
        this.nombre = nombre;
        this.notaParcial1 = notaParcial1;
        this.notaParcial2 = notaParcial2;
        this.examenFinal = examenFinal;
    }

    /** Nota ponderada antes de aplicar cualquier curva. */
    public double calcularNotaOriginal() {
        return notaParcial1 * PESO_PARCIAL1 + notaParcial2 * PESO_PARCIAL2 + examenFinal * PESO_FINAL;
    }

    public void setCurva(double puntos) {
        this.curva = puntos;
    }

    /** Nota ponderada más la curva, limitada a 10. */
    public double calcularNotaFinal() {
        return Math.min(10.0, calcularNotaOriginal() + curva);
    }

    public boolean aprobo() {
        return calcularNotaFinal() >= 6.0;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-10s P1: %4.1f  P2: %4.1f  Final: %4.1f  => Ponderada: %5.2f  Con curva: %5.2f  %s",
                nombre, notaParcial1, notaParcial2, examenFinal, calcularNotaOriginal(), calcularNotaFinal(),
                aprobo() ? "APROBADO" : "REPROBADO");
    }
}
