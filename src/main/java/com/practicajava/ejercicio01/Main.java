package com.practicajava.ejercicio01;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 1 - Cajero Automático: Transferencias Bancarias.
 * Se añade a la clase CuentaBancaria el método transferir(destino, monto)
 * y una opción en el menú para transferir dinero a otra cuenta validando
 * que exista saldo suficiente.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 1: TRANSFERENCIAS BANCARIAS ===");

        // Datos de prueba: dos cuentas precargadas
        CuentaBancaria miCuenta = new CuentaBancaria("Ana López", "1234", 1000);
        CuentaBancaria otraCuenta = new CuentaBancaria("Carlos Pérez", "5678", 500);

        // Demostración automática
        System.out.println("-- Demostración con datos de prueba --");
        System.out.println("Antes:   " + miCuenta + " | " + otraCuenta);
        miCuenta.transferir(otraCuenta, 250);
        System.out.println("Transferencia de $250 de Ana a Carlos realizada.");
        System.out.println("Después: " + miCuenta + " | " + otraCuenta);
        System.out.println("Intento de transferir $5000 (debe fallar):");
        miCuenta.transferir(otraCuenta, 5000);

        System.out.println("\n-- Cajero interactivo (cuenta de Ana López, PIN 1234) --");
        String pin = Entrada.leerTexto("Introduce el PIN: ");
        if (!miCuenta.validarPin(pin)) {
            System.out.println("PIN incorrecto. Fin del ejercicio.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir a " + otraCuenta.getTitular());
            System.out.println("0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> System.out.printf("Saldo actual: $%.2f%n", miCuenta.getSaldo());
                case 2 -> {
                    double m = Entrada.leerDouble("Monto a depositar: ");
                    System.out.println(miCuenta.depositar(m) ? "Depósito realizado." : "Monto no válido.");
                }
                case 3 -> {
                    double m = Entrada.leerDouble("Monto a retirar: ");
                    System.out.println(miCuenta.retirar(m) ? "Retiro realizado." : "Saldo insuficiente o monto no válido.");
                }
                case 4 -> {
                    double m = Entrada.leerDouble("Monto a transferir: ");
                    if (miCuenta.transferir(otraCuenta, m)) {
                        System.out.println("Transferencia exitosa.");
                        System.out.println("  Tu cuenta: " + miCuenta);
                        System.out.println("  Destino:   " + otraCuenta);
                    }
                }
                case 0 -> System.out.println("Gracias por usar el cajero.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
