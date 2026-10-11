package com.practicajava.ejercicio02;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 2 - Cajero Automático: Historial de Movimientos.
 * CuentaBancaria guarda un ArrayList<String> con las últimas 5 transacciones
 * (por ejemplo "Depósito: +$50", "Retiro: -$20") y el menú incluye la
 * opción "Consultar Movimientos".
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 2: HISTORIAL DE MOVIMIENTOS ===");

        CuentaBancaria cuenta = new CuentaBancaria("Ana López", "1234", 1000);

        // Datos de prueba: 6 operaciones para comprobar que solo se guardan 5
        System.out.println("-- Demostración: se realizan 6 operaciones --");
        cuenta.depositar(50);
        cuenta.retirar(20);
        cuenta.depositar(200);
        cuenta.retirar(75.5);
        cuenta.depositar(10);
        cuenta.retirar(100);
        cuenta.mostrarMovimientos();

        System.out.println("\n-- Cajero interactivo (PIN 1234) --");
        if (!cuenta.validarPin(Entrada.leerTexto("Introduce el PIN: "))) {
            System.out.println("PIN incorrecto. Fin del ejercicio.");
            return;
        }
        int opcion;
        do {
            System.out.println("\n1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Consultar Movimientos");
            System.out.println("0. Salir");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> System.out.printf("Saldo: $%.2f%n", cuenta.getSaldo());
                case 2 -> System.out.println(cuenta.depositar(Entrada.leerDouble("Monto: "))
                        ? "Depósito realizado." : "Monto no válido.");
                case 3 -> System.out.println(cuenta.retirar(Entrada.leerDouble("Monto: "))
                        ? "Retiro realizado." : "Saldo insuficiente o monto no válido.");
                case 4 -> cuenta.mostrarMovimientos();
                case 0 -> System.out.println("Gracias por usar el cajero.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
