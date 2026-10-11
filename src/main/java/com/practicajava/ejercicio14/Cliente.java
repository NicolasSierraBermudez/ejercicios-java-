package com.practicajava.ejercicio14;

/**
 * Ejercicio 14 - Cliente de la tienda. Cada cliente tiene su propio carrito.
 */
public class Cliente {

    private final String nombre;
    private final String email;
    private final Carrito carrito;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.carrito = new Carrito(this);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return nombre + " <" + email + ">";
    }
}
