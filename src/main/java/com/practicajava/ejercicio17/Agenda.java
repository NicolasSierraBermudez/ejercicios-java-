package com.practicajava.ejercicio17;

import java.util.ArrayList;

/**
 * Ejercicio 17 - Agenda que solo admite contactos con datos válidos.
 */
public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList<>();

    /**
     * Intenta crear y agregar un contacto. Devuelve un mensaje con el resultado.
     */
    public String agregarContacto(String nombre, String telefono, String email) {
        try {
            Contacto c = new Contacto(nombre, telefono, email);
            for (Contacto existente : contactos) {
                if (existente.getNombre().equalsIgnoreCase(c.getNombre())) {
                    return "Error: ya existe un contacto con ese nombre.";
                }
            }
            contactos.add(c);
            return "Contacto agregado: " + c.getNombre();
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    public void mostrarContactos() {
        System.out.println("Agenda (" + contactos.size() + " contactos):");
        for (Contacto c : contactos) {
            System.out.println("  " + c);
        }
    }
}
