package com.practicajava.ejercicio05;

/**
 * Ejercicio 5 - CuentaAhorro: al depositar se aplica un interés adicional
 * sobre el monto depositado.
 */
public class CuentaAhorro extends CuentaBancaria {

    private final double tasaInteres; // por ejemplo 0.02 = 2 %

    public CuentaAhorro(String titular, String pin, double saldoInicial, double tasaInteres) {
        super(titular, pin, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        double interes = monto * tasaInteres;
        saldo += monto + interes;
        System.out.printf("  Interés aplicado (%.1f%%): +$%.2f%n", tasaInteres * 100, interes);
        return true;
    }

    @Override
    public String getTipo() {
        return String.format("Cuenta Ahorro %.1f%%", tasaInteres * 100);
    }
}
