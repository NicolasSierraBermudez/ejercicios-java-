package com.practicajava.ejercicio13;

/**
 * Ejercicio 13 - Producto electrónico con meses de garantía.
 */
public class ProductoElectronico extends Producto {

    private final int mesesGarantia;

    public ProductoElectronico(int codigo, String nombre, double precio, int mesesGarantia) {
        super(codigo, nombre, precio);
        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    @Override
    public String getDetalle() {
        return "Electrónico - Garantía: " + mesesGarantia + " meses";
    }
}
