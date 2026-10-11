package com.practicajava.ejercicio05;

/**
 * Ejercicio 5 - CuentaCorriente: permite retirar más dinero del disponible
 * hasta un límite de sobregiro (el saldo puede quedar negativo).
 */
public class CuentaCorriente extends CuentaBancaria {

    private final double limiteSobregiro;

    public CuentaCorriente(String titular, String pin, double saldoInicial, double limiteSobregiro) {
        super(titular, pin, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo + limiteSobregiro) {
            return false;
        }
        saldo -= monto;
        if (saldo < 0) {
            System.out.printf("  Atención: cuenta en sobregiro ($%.2f).%n", saldo);
        }
        return true;
    }

    @Override
    public String getTipo() {
        return String.format("Cuenta Corriente (sobregiro $%.0f)", limiteSobregiro);
    }
}
