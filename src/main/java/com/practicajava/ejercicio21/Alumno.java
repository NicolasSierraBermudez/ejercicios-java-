package com.practicajava.ejercicio21;

/**
 * Ejercicio 21 - Alumno con nota original y nota con curva.
 */
public class Alumno {

    public static final double NOTA_MAXIMA = 10.0;
    public static final double NOTA_APROBADO = 6.0;

    private final String nombre;
    private final double notaOriginal;
    private double notaFinal;

    public Alumno(String nombre, double notaOriginal) {
        this.nombre = nombre;
        this.notaOriginal = notaOriginal;
        this.notaFinal = notaOriginal;
    }

    /**
     * Incrementa la nota ORIGINAL en el porcentaje indicado, sin superar 10.
     * Ej.: nota 7 con curva del 10 % -> 7.7
     */
    public void aplicarCurvaPorcentual(double porcentaje) {
        double nueva = notaOriginal * (1 + porcentaje / 100.0);
        notaFinal = Math.min(NOTA_MAXIMA, nueva);
    }

    public void quitarCurva() {
        notaFinal = notaOriginal;
    }

    public boolean aprobo() {
        return notaFinal >= NOTA_APROBADO;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNotaOriginal() {
        return notaOriginal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return String.format("%-14s Original: %5.2f  Con curva: %5.2f  %s",
                nombre, notaOriginal, notaFinal, aprobo() ? "APROBADO" : "REPROBADO");
    }
}
