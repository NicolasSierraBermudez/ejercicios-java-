package com.practicajava.ejercicio17;

/**
 * Ejercicio 17 - Contacto con validación de datos.
 * El teléfono debe tener exactamente 9 dígitos numéricos y el email
 * debe contener "@" y ".".
 */
public class Contacto {

    private final String nombre;
    private final String telefono;
    private final String email;

    /**
     * Crea el contacto validando los datos.
     * @throws IllegalArgumentException si algún dato no es válido.
     */
    public Contacto(String nombre, String telefono, String email) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido: debe tener 9 dígitos y solo números.");
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: debe contener '@' y '.'.");
        }
        this.nombre = nombre.trim();
        this.telefono = telefono;
        this.email = email;
    }

    /** Solo números y exactamente 9 dígitos. */
    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.length() != 9) {
            return false;
        }
        for (char ch : telefono.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    /** Debe contener "@" y ".", y el "." debe aparecer después de la "@". */
    public static boolean validarEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            return false;
        }
        int arroba = email.indexOf('@');
        return arroba > 0 && email.lastIndexOf('.') > arroba + 1 && !email.endsWith(".");
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
