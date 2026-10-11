package com.practicajava.ejercicio13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 13 - Producto alimenticio con fecha de caducidad.
 */
public class ProductoAlimenticio extends Producto {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate fechaCaducidad;

    public ProductoAlimenticio(int codigo, String nombre, double precio, LocalDate fechaCaducidad) {
        super(codigo, nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public boolean estaCaducado() {
        return fechaCaducidad.isBefore(LocalDate.now());
    }

    @Override
    public String getDetalle() {
        return "Alimento - Caduca: " + fechaCaducidad.format(FMT) + (estaCaducado() ? " (¡CADUCADO!)" : "");
    }
}
