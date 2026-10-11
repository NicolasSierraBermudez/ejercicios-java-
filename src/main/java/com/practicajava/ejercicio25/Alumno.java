package com.practicajava.ejercicio25;

/**
 * Ejercicio 25 - Alumno con nota original y nota con curva.
 */
public class Alumno {

    public static final double NOTA_APROBADO = 6.0;

    private final String nombre;
    private final double notaOriginal;
    private double notaFinal;

    public Alumno(String nombre, double notaOriginal) {
        this.nombre = nombre;
        this.notaOriginal = notaOriginal;
        this.notaFinal = notaOriginal;
    }

    public void aplicarCurva(double puntos) {
        notaFinal = Math.min(10.0, notaOriginal + puntos);
    }

    public boolean aproboOriginal() {
        return notaOriginal >= NOTA_APROBADO;
    }

    public boolean aproboConCurva() {
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
        String cambio = (!aproboOriginal() && aproboConCurva()) ? "  <- ¡pasó a APROBADO!" : "";
        return String.format("%-10s Original: %5.2f (%s)  Con curva: %5.2f (%s)%s",
                nombre, notaOriginal, aproboOriginal() ? "A" : "R", notaFinal, aproboConCurva() ? "A" : "R", cambio);
    }
}
