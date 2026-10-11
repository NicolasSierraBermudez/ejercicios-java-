package com.practicajava.ejercicio05;

import com.practicajava.util.Entrada;
import java.util.ArrayList;

/**
 * EJERCICIO 5 - Cajero Automático: Herencia (Tipos de Cuenta).
 * Cuenta (abstracta) -> CuentaBancaria -> CuentaAhorro (interés al depositar)
 *                                      -> CuentaCorriente (límite de sobregiro)
 * Se demuestra el polimorfismo: el cajero trabaja con referencias de tipo Cuenta.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 5: HERENCIA - TIPOS DE CUENTA ===");

        // Datos de prueba
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new CuentaBancaria("Ana", "1111", 1000));
        cuentas.add(new CuentaAhorro("Carlos", "2222", 2000, 0.02));
        cuentas.add(new CuentaCorriente("Lucía", "3333", 300, 500));

        System.out.println("-- Demostración polimórfica: depositar $100 y retirar $600 en cada cuenta --");
        for (Cuenta c : cuentas) {
            System.out.println(c);
            c.depositar(100);
            boolean ok = c.retirar(600);
            System.out.println("  Retiro de $600: " + (ok ? "OK" : "RECHAZADO"));
            System.out.println("  -> " + c);
        }
        System.out.println("PINs de prueba: Ana=1111, Carlos=2222, Lucía=3333");

        while (true) {
            String titular = Entrada.leerTexto("\nTitular (o 'salir'): ");
            if (titular.isEmpty() || titular.equalsIgnoreCase("salir")) {
                System.out.println("Fin del ejercicio 5.");
                return;
            }
            Cuenta cuenta = null;
            for (Cuenta c : cuentas) {
                if (c.getTitular().equalsIgnoreCase(titular)) {
                    cuenta = c;
                }
            }
            if (cuenta == null || !cuenta.validarPin(Entrada.leerTexto("PIN: "))) {
                System.out.println("Titular o PIN incorrectos.");
                continue;
            }
            int opcion;
            do {
                System.out.println("\n" + cuenta);
                System.out.println("1. Depositar  2. Retirar  0. Cerrar sesión");
                opcion = Entrada.leerEntero("Opción: ");
                switch (opcion) {
                    case 1 -> System.out.println(cuenta.depositar(Entrada.leerDouble("Monto: "))
                            ? "Depósito realizado." : "Monto no válido.");
                    case 2 -> System.out.println(cuenta.retirar(Entrada.leerDouble("Monto: "))
                            ? "Retiro realizado." : "Retiro rechazado (fondos/sobregiro insuficiente).");
                    case 0 -> System.out.println("Sesión cerrada.");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}
