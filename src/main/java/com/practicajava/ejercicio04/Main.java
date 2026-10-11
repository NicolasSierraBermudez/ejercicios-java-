package com.practicajava.ejercicio04;

import com.practicajava.util.Entrada;

/**
 * EJERCICIO 4 - Cajero Automático: Clase Banco.
 * Se crea la clase Banco con un ArrayList<CuentaBancaria> y los métodos
 * buscarCuenta(titular) y validarPin(titular, pin). El main interactúa
 * únicamente con el objeto Banco.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 4: CLASE BANCO ===");

        // Datos de prueba
        Banco banco = new Banco("Banco Práctica Java");
        banco.agregarCuenta(new CuentaBancaria("Ana", "1111", 1500));
        banco.agregarCuenta(new CuentaBancaria("Carlos", "2222", 800));
        banco.agregarCuenta(new CuentaBancaria("Lucía", "3333", 2300));
        banco.listarCuentas();

        System.out.println("\n-- Demostración --");
        System.out.println("validarPin(\"Ana\", \"1111\") -> " + banco.validarPin("Ana", "1111"));
        System.out.println("validarPin(\"Ana\", \"0000\") -> " + banco.validarPin("Ana", "0000"));
        System.out.println("buscarCuenta(\"Pedro\") -> " + banco.buscarCuenta("Pedro"));
        System.out.println("PINs de prueba: Ana=1111, Carlos=2222, Lucía=3333");

        while (true) {
            String titular = Entrada.leerTexto("\nTitular (o 'salir'): ");
            if (titular.isEmpty() || titular.equalsIgnoreCase("salir")) {
                System.out.println("Fin del ejercicio 4.");
                return;
            }
            String pin = Entrada.leerTexto("PIN: ");
            if (!banco.validarPin(titular, pin)) {
                System.out.println("Titular o PIN incorrectos.");
                continue;
            }
            CuentaBancaria cuenta = banco.buscarCuenta(titular);
            int opcion;
            do {
                System.out.println("\n[" + cuenta.getTitular() + "] 1.Saldo 2.Depositar 3.Retirar 4.Transferir 5.Ver cuentas 0.Cerrar sesión");
                opcion = Entrada.leerEntero("Opción: ");
                switch (opcion) {
                    case 1 -> System.out.printf("Saldo: $%.2f%n", cuenta.getSaldo());
                    case 2 -> System.out.println(cuenta.depositar(Entrada.leerDouble("Monto: "))
                            ? "Depósito realizado." : "Monto no válido.");
                    case 3 -> System.out.println(cuenta.retirar(Entrada.leerDouble("Monto: "))
                            ? "Retiro realizado." : "Saldo insuficiente o monto no válido.");
                    case 4 -> {
                        CuentaBancaria destino = banco.buscarCuenta(Entrada.leerTexto("Titular destino: "));
                        if (destino == null) {
                            System.out.println("La cuenta destino no existe.");
                        } else {
                            System.out.println(cuenta.transferir(destino, Entrada.leerDouble("Monto: "))
                                    ? "Transferencia realizada." : "No se pudo transferir (saldo o monto no válido).");
                        }
                    }
                    case 5 -> banco.listarCuentas();
                    case 0 -> System.out.println("Sesión cerrada.");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 0);
        }
    }
}
