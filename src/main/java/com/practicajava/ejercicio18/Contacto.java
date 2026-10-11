package com.practicajava.ejercicio18;

/**
 * Ejercicio 18 - Contacto de la agenda.
 */
public class Contacto {

    private final String nombre;
    private final String telefono;
    private final String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%-18s Tel: %-10s Email: %s", nombre, telefono, email);
    }
}
