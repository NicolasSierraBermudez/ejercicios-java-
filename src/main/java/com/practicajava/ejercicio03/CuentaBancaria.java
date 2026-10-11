package com.practicajava.ejercicio03;

/**
 * Ejercicio 3 - Cuenta bancaria usada dentro de una lista de múltiples cuentas.
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
        return String.format("%-15s Saldo: $%.2f", titular, saldo);
    }
}
