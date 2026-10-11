package com.practicajava.ejercicio04;

/**
 * Ejercicio 4 - Cuenta bancaria gestionada por la clase Banco.
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

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null || destino == this || !retirar(monto)) {
            return false;
        }
        destino.depositar(monto);
        return true;
    }

    public String getTitular() {
        return titular;
    }

    public String getPin() {
        return pin;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("%-15s Saldo: $%.2f", titular, saldo);
    }
}
