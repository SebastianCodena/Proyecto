/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author SebastianCodena
 */
import java.util.ArrayList;
import java.util.List;
import modelo.Activo;
import modelo.Hardware;
import modelo.Periferico;
import modelo.Licencia;
import org.junit.Test;
import static org.junit.Assert.*;
import servicio.ServicioMantenimiento;
import servicio.ServicioMantenimiento;



public class ServicioMantenimientoTest {


    @Test
    public void calcularCostoTotalMantenimiento(){


        List<Activo> activos = new ArrayList<>();


        activos.add(
                new Hardware(
                        1,
                        "Laptop",
                        "Dell",
                        "XPS",
                        "2025",
                        1000
                )
        );


        activos.add(
                new Periferico(
                        2,
                        "Mouse",
                        "Logitech",
                        "G203",
                        "2025",
                        50
                )
        );


        activos.add(
                new Licencia(
                        3,
                        "Office",
                        "Microsoft",
                        "365",
                        "2025",
                        200
                )
        );


        ServicioMantenimiento servicio =
                new ServicioMantenimiento();


        double resultado =
                servicio.calcularCostoTotal(activos);



        assertEquals(132.0, resultado,0.001);

    }

}