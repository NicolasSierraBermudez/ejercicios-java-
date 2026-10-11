package com.practicajava.ejercicio20;

/**
 * Ejercicio 20 - Contacto que sabe convertirse a/desde una línea de texto.
 * Formato de archivo: nombre;telefono;email;grupo
 */
public class Contacto {

    public static final String SEPARADOR = ";";

    private final String nombre;
    private final String telefono;
    private final String email;
    private final String grupo;

    public Contacto(String nombre, String telefono, String email, String grupo) {
        // Se elimina el separador para no romper el formato del archivo
        this.nombre = limpiar(nombre);
        this.telefono = limpiar(telefono);
        this.email = limpiar(email);
        this.grupo = limpiar(grupo);
    }

    private static String limpiar(String s) {
        return s == null ? "" : s.replace(SEPARADOR, ",").trim();
    }

    /** Convierte el contacto en una línea para guardar en el archivo. */
    public String aLineaTexto() {
        return String.join(SEPARADOR, nombre, telefono, email, grupo);
    }

    /** Crea un contacto a partir de una línea del archivo. Devuelve null si la línea es inválida. */
    public static Contacto desdeLineaTexto(String linea) {
        String[] partes = linea.split(SEPARADOR, -1);
        if (partes.length != 4 || partes[0].isBlank()) {
            return null;
        }
        return new Contacto(partes[0], partes[1], partes[2], partes[3]);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("%-18s Tel: %-10s Email: %-20s [%s]", nombre, telefono, email, grupo);
    }
}
