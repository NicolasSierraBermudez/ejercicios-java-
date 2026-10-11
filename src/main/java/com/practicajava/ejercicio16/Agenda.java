package com.practicajava.ejercicio16;

import java.util.ArrayList;

/**
 * Ejercicio 16 - Agenda con ArrayList.
 * Antes la agenda usaba un array fijo de 20 posiciones (Contacto[20]) y un
 * contador. Con ArrayList<Contacto> no hay límite de tamaño ni huecos al
 * eliminar: la lista crece y se reorganiza sola.
 */
public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList<>();

    /** Agrega un contacto si no existe otro con el mismo nombre. */
    public boolean agregarContacto(Contacto c) {
        if (buscarContacto(c.getNombre()) != null) {
            return false;
        }
        contactos.add(c);
        return true;
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String nombre) {
        Contacto c = buscarContacto(nombre);
        return c != null && contactos.remove(c);
    }

    public int getCantidad() {
        return contactos.size();
    }

    public void mostrarContactos() {
        System.out.println("Agenda (" + contactos.size() + " contactos, sin límite de capacidad):");
        if (contactos.isEmpty()) {
            System.out.println("  (vacía)");
        }
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + contactos.get(i));
        }
    }
}
