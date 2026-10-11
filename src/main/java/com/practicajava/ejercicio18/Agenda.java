package com.practicajava.ejercicio18;

import java.util.ArrayList;

/**
 * Ejercicio 18 - Agenda con búsqueda parcial.
 */
public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    /**
     * Devuelve todos los contactos cuyo nombre CONTIENE el texto buscado,
     * sin distinguir mayúsculas/minúsculas. Ej.: "an" encuentra "Ana" y "Juan".
     */
    public ArrayList<Contacto> buscarContacto(String nombre) {
        ArrayList<Contacto> resultados = new ArrayList<>();
        String texto = nombre.trim().toLowerCase();
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(texto)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public void mostrarContactos() {
        System.out.println("Agenda (" + contactos.size() + " contactos):");
        for (Contacto c : contactos) {
            System.out.println("  " + c);
        }
    }

    /** Muestra el resultado de una búsqueda parcial. */
    public void mostrarBusqueda(String texto) {
        ArrayList<Contacto> res = buscarContacto(texto);
        System.out.println("Búsqueda \"" + texto + "\": " + res.size() + " coincidencia(s)");
        for (Contacto c : res) {
            System.out.println("  " + c);
        }
    }
}
