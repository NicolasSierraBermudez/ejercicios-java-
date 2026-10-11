package com.practicajava.ejercicio19;

import java.util.ArrayList;

/**
 * Ejercicio 19 - Agenda con grupos de contactos.
 */
public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    /** Muestra solo los contactos que pertenecen al grupo indicado. */
    public void mostrarContactosPorGrupo(String grupo) {
        String g = Contacto.normalizarGrupo(grupo);
        if (g == null) {
            System.out.println("Grupo no válido. Usa: Familia, Trabajo o Amigos.");
            return;
        }
        System.out.println("Contactos del grupo " + g + ":");
        int n = 0;
        for (Contacto c : contactos) {
            if (c.getGrupo().equals(g)) {
                System.out.println("  " + c);
                n++;
            }
        }
        if (n == 0) {
            System.out.println("  (ninguno)");
        }
    }

    /** Muestra todos los contactos agrupados. */
    public void mostrarTodosAgrupados() {
        for (String g : Contacto.GRUPOS) {
            mostrarContactosPorGrupo(g);
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
}
