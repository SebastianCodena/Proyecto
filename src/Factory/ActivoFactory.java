/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author SebastianCodena
 */
import modelo.Activo;
import modelo.Hardware;
import modelo.Licencia;
import modelo.Periferico;

public class ActivoFactory {

    private ActivoFactory() {
    }

    public static Activo crearActivo(String tipo) {

        switch (tipo) {

            case "Hardware":
                return new Hardware();

            case "Periferico":
                return new Periferico();

            case "Licencia":
                return new Licencia();

            default:
                throw new IllegalArgumentException("Tipo de activo no válido.");

        }

    }

}