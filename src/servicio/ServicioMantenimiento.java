/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author SebastianCodena
 */
import java.util.List;
import modelo.Activo;

public class ServicioMantenimiento {

    public double calcularCostoTotal(List<Activo> activos) {

        double total = 0;

        for (Activo activo : activos) {

            total += activo.calcularCostoMantenimiento();

        }

        return total;

    }
    public void mostrarCostos(List<Activo> activos){

    for(Activo activo : activos){

        System.out.println(
                activo.getNombre()
                + " -> "
                + activo.calcularCostoMantenimiento());

    }

}
    public String generarReporte(List<Activo> activos){

    StringBuilder reporte = new StringBuilder();

    double total = 0;

    for(Activo activo : activos){

        double costo = activo.calcularCostoMantenimiento();

        reporte.append(activo.getNombre())
               .append(" - ")
               .append(costo)
               .append("\n");

        total += costo;

    }

    reporte.append("\nCosto Total: ").append(total);

    return reporte.toString();

}

}