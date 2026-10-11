package com.practicajava.ejercicio03;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 3 - Cajero Automático: Gestión de Múltiples Cuentas.
 * El main maneja un ArrayList<CuentaBancaria>. Al iniciar se pide el
 * "titular" para saber con qué cuenta operar.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 3: GESTIÓN DE MÚLTIPLES CUENTAS ===");

        // Datos de prueba
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaBancaria("Ana", "1111", 1500));
        cuentas.add(new CuentaBancaria("Carlos", "2222", 800));
        cuentas.add(new CuentaBancaria("Lucía", "3333", 2300));

        System.out.println("Cuentas registradas (datos de prueba):");
        for (CuentaBancaria c : cuentas) {
            System.out.println("  " + c);
        }
        System.out.println("PINs de prueba: Ana=1111, Carlos=2222, Lucía=3333");

        while (true) {
            String titular = Entrada.leerTexto("\nIntroduce el titular (o 'salir'): ");
            if (titular.isEmpty() || titular.equalsIgnoreCase("salir")) {
                System.out.println("Fin del ejercicio 3.");
                return;
            }
            CuentaBancaria cuenta = null;
            for (CuentaBancaria c : cuentas) {
                if (c.getTitular().equalsIgnoreCase(titular)) {
                    cuenta = c;
                    break;
                }
            }
            if (cuenta == null) {
                System.out.println("No existe ninguna cuenta con ese titular.");
                continue;
            }
            if (!cuenta.validarPin(Entrada.leerTexto("PIN: "))) {
                System.out.println("PIN incorrecto.");
                continue;
            }
            operar(cuenta);
        }
    }

    /** Menú de operaciones sobre la cuenta seleccionada. */
    private static void operar(CuentaBancaria cuenta) {
        int opcion;
        do {
            System.out.println("\nBienvenido/a, " + cuenta.getTitular());
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("0. Cerrar sesión");
            opcion = Entrada.leerEntero("Opción: ");
            switch (opcion) {
                case 1 -> System.out.printf("Saldo: $%.2f%n", cuenta.getSaldo());
                case 2 -> System.out.println(cuenta.depositar(Entrada.leerDouble("Monto: "))
                        ? "Depósito realizado." : "Monto no válido.");
                case 3 -> System.out.println(cuenta.retirar(Entrada.leerDouble("Monto: "))
                        ? "Retiro realizado." : "Saldo insuficiente o monto no válido.");
                case 0 -> System.out.println("Sesión cerrada.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
