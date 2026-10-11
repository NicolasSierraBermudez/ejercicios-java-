package com.practicajava.ejercicio04;

import java.util.ArrayList;

/**
 * Ejercicio 4 - Clase Banco.
 * Contiene la lista de cuentas y encapsula la búsqueda y validación de PIN.
 */
public class Banco {

    private final String nombre;
    private final ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }

    /** Busca una cuenta por titular (sin distinguir mayúsculas). Devuelve null si no existe. */
    public CuentaBancaria buscarCuenta(String titular) {
        for (CuentaBancaria c : cuentas) {
            if (c.getTitular().equalsIgnoreCase(titular)) {
                return c;
            }
        }
        return null;
    }

    /** Devuelve true si el titular existe y el PIN coincide. */
    public boolean validarPin(String titular, String pin) {
        CuentaBancaria c = buscarCuenta(titular);
        return c != null && c.getPin().equals(pin);
    }

    public void listarCuentas() {
        System.out.println("Cuentas del " + nombre + ":");
        for (CuentaBancaria c : cuentas) {
            System.out.println("  " + c);
        }
    }

    public String getNombre() {
        return nombre;
    }
}
