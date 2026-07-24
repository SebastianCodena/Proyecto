/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author SebastianCodena
 */
import modelo.Hardware;
import modelo.Licencia;
import modelo.Periferico;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivoTest {


    @Test
    public void probarCostoMantenimientoHardware(){

        Hardware hardware = new Hardware(
                1,
                "Laptop Dell",
                "Dell",
                "Inspiron",
                "2025-01-10",
                1000
        );


        double resultado = hardware.calcularCostoMantenimiento();


        assertEquals(120, resultado,0);

    }



    @Test
    public void probarCostoMantenimientoPeriferico(){

        Periferico periferico = new Periferico(
                2,
                "Mouse",
                "Logitech",
                "G203",
                "2025-01-10",
                50
        );


        double resultado = periferico.calcularCostoMantenimiento();


        assertEquals(4, resultado,0);

    }



    @Test
    public void probarCostoMantenimientoLicencia(){

        Licencia licencia = new Licencia(
                3,
                "Windows",
                "Microsoft",
                "Windows 11",
                "2025-01-10",
                200
        );


        double resultado = licencia.calcularCostoMantenimiento();


        assertEquals(8, resultado,0);

    }

}