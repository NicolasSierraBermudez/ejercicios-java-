package com.practicajava.ejercicio20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Ejercicio 20 - Agenda con persistencia en archivo de texto.
 * Cada línea del archivo representa un contacto: nombre;telefono;email;grupo
 */
public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList<>();
    private final Path archivo;

    public Agenda(String nombreArchivo) {
        this.archivo = Paths.get(nombreArchivo).toAbsolutePath();
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    public boolean eliminarContacto(String nombre) {
        return contactos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
    }

    public void vaciar() {
        contactos.clear();
    }

    public int getCantidad() {
        return contactos.size();
    }

    /** Guarda todos los contactos en el archivo (sobrescribe el contenido anterior). */
    public boolean guardarEnArchivo() {
        try (BufferedWriter bw = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)) {
            for (Contacto c : contactos) {
                bw.write(c.aLineaTexto());
                bw.newLine();
            }
            System.out.println("Agenda guardada (" + contactos.size() + " contactos) en: " + archivo);
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    /** Reemplaza los contactos en memoria por los del archivo. */
    public boolean cargarDesdeArchivo() {
        if (!Files.exists(archivo)) {
            System.out.println("El archivo " + archivo + " no existe todavía.");
            return false;
        }
        ArrayList<Contacto> cargados = new ArrayList<>();
        int lineasInvalidas = 0;
        try (BufferedReader br = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                Contacto c = Contacto.desdeLineaTexto(linea);
                if (c != null) {
                    cargados.add(c);
                } else {
                    lineasInvalidas++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return false;
        }
        contactos.clear();
        contactos.addAll(cargados);
        System.out.println("Cargados " + cargados.size() + " contactos desde " + archivo
                + (lineasInvalidas > 0 ? " (" + lineasInvalidas + " líneas ignoradas)" : ""));
        return true;
    }

    public void mostrarContactos() {
        System.out.println("Agenda (" + contactos.size() + " contactos):");
        if (contactos.isEmpty()) {
            System.out.println("  (vacía)");
        }
        for (Contacto c : contactos) {
            System.out.println("  " + c);
        }
    }
}
