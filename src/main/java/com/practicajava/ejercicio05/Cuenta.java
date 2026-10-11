package com.practicajava.ejercicio05;

/**
 * Ejercicio 5 - Clase abstracta Cuenta.
 * Define los atributos y operaciones comunes a cualquier tipo de cuenta.
 */
public abstract class Cuenta {

    protected final String titular;
    protected final String pin;
    protected double saldo;

    protected Cuenta(String titular, String pin, double saldoInicial) {
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldoInicial;
    }

    /** Cada tipo de cuenta decide cómo se deposita. */
    public abstract boolean depositar(double monto);

    /** Cada tipo de cuenta decide cómo se retira. */
    public abstract boolean retirar(double monto);

    /** Nombre descriptivo del tipo de cuenta. */
    public abstract String getTipo();

    public boolean validarPin(String intento) {
        return pin.equals(intento);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - Saldo: $%.2f", getTipo(), titular, saldo);
    }
}
