package com.practicajava.ejercicio02;

import java.util.ArrayList;

/**
 * Ejercicio 2 - Historial de Movimientos.
 * La cuenta guarda en un ArrayList las últimas 5 transacciones realizadas.
 */
public class CuentaBancaria {

    private static final int MAX_MOVIMIENTOS = 5;

    private final String titular;
    private final String pin;
    private double saldo;
    private final ArrayList<String> movimientos = new ArrayList<>();

    public CuentaBancaria(String titular, String pin, double saldoInicial) {
        this.titular = titular;
        this.pin = pin;
        this.saldo = saldoInicial;
    }

    /** Registra un movimiento y conserva únicamente los 5 más recientes. */
    private void registrarMovimiento(String descripcion) {
        movimientos.add(descripcion);
        if (movimientos.size() > MAX_MOVIMIENTOS) {
            movimientos.remove(0);
        }
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        registrarMovimiento(String.format("Depósito: +$%.2f", monto));
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        registrarMovimiento(String.format("Retiro: -$%.2f", monto));
        return true;
    }

    /** Muestra las últimas transacciones (de la más antigua a la más reciente). */
    public void mostrarMovimientos() {
        System.out.println("Últimos movimientos de " + titular + ":");
        if (movimientos.isEmpty()) {
            System.out.println("  (sin movimientos)");
        }
        for (int i = 0; i < movimientos.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + movimientos.get(i));
        }
        System.out.printf("Saldo actual: $%.2f%n", saldo);
    }

    public boolean validarPin(String intento) {
        return pin.equals(intento);
    }

    public ArrayList<String> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
