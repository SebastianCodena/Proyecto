/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SebastianCodena
 */
public class Hardware extends Activo {

    public Hardware() {
    }

    public Hardware(int id, String nombre, String marca,
            String modelo, String fechaCompra, double valor) {

        super(id, nombre, marca, modelo, fechaCompra, valor);
    }

    @Override
    public double calcularCostoMantenimiento() {
        return getValor() * 0.12;
    }

}