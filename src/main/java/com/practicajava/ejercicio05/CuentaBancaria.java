package com.practicajava.ejercicio05;

/**
 * Ejercicio 5 - CuentaBancaria hereda de Cuenta.
 * Implementa el comportamiento estándar: depósitos positivos y retiros
 * solo si hay saldo suficiente.
 */
public class CuentaBancaria extends Cuenta {

    public CuentaBancaria(String titular, String pin, double saldoInicial) {
        super(titular, pin, saldoInicial);
    }

    @Override
    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        return true;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        return true;
    }

    @Override
    public String getTipo() {
        return "Cuenta Estándar";
    }
}
