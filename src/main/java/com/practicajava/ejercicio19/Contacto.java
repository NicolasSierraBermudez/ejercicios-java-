package com.practicajava.ejercicio19;

/**
 * Ejercicio 19 - Contacto con grupo ("Familia", "Trabajo", "Amigos").
 */
public class Contacto {

    /** Grupos permitidos. */
    public static final String[] GRUPOS = {"Familia", "Trabajo", "Amigos"};

    private final String nombre;
    private final String telefono;
    private final String email;
    private String grupo;

    public Contacto(String nombre, String telefono, String email, String grupo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        setGrupo(grupo);
    }

    /** Normaliza el grupo; si no es uno de los permitidos, se asigna "Amigos". */
    public final void setGrupo(String grupo) {
        this.grupo = normalizarGrupo(grupo);
        if (this.grupo == null) {
            this.grupo = "Amigos";
        }
    }

    /** Devuelve el nombre oficial del grupo o null si no es válido. */
    public static String normalizarGrupo(String grupo) {
        if (grupo == null) {
            return null;
        }
        for (String g : GRUPOS) {
            if (g.equalsIgnoreCase(grupo.trim())) {
                return g;
            }
        }
        return null;
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

    public String getGrupo() {
        return grupo;
    }

    @Override
    public String toString() {
        return String.format("%-18s Tel: %-10s Email: %-20s [%s]", nombre, telefono, email, grupo);
    }
}
