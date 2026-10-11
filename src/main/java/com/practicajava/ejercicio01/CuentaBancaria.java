package com.practicajava.ejercicio01;

/**
 * Ejercicio 1 - Transferencias Bancarias.
 * Cuenta bancaria básica con depósito, retiro y transferencia a otra cuenta.
 */
public class CuentaBancaria {

    private final String titular;
    private final String pin;
    private double saldo;

    public CuentaBancaria(String titular, String pin, double saldoInicial) {
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        return true;
    }

    /**
     * Transfiere dinero desde esta cuenta a la cuenta destino.
     * Valida que el monto sea positivo, que exista saldo suficiente
     * y que la cuenta destino no sea la misma.
     */
    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null || destino == this) {
            System.out.println("  Cuenta destino no válida.");
            return false;
        }
        if (monto <= 0) {
            System.out.println("  El monto debe ser mayor que cero.");
            return false;
        }
        if (monto > saldo) {
            System.out.printf("  Saldo insuficiente. Saldo disponible: $%.2f%n", saldo);
            return false;
        }
        this.saldo -= monto;
        destino.saldo += monto;
        return true;
    }

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
        return String.format("%s - Saldo: $%.2f", titular, saldo);
    }
}
