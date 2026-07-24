/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author SebastianCodena
 */
import dao.ActivoDao;
import java.util.List;
import modelo.Activo;


public class ReporteService {


    private ActivoDao activoDao;


    public ReporteService(){

        activoDao = new ActivoDao();

    }


    public void generarReporte(){


        List<Activo> activos = activoDao.listar();


        double valorTotal = 0;
        double costoMantenimientoTotal = 0;


        System.out.println("\n====================================");
        System.out.println("       REPORTE DE ACTIVOS");
        System.out.println("====================================");


        for(Activo activo : activos){


            double mantenimiento =
                    activo.calcularCostoMantenimiento();


            System.out.println("\nID: "
                    + activo.getId());

            System.out.println("Nombre: "
                    + activo.getNombre());

            System.out.println("Tipo: "
                    + activo.getClass().getSimpleName());

            System.out.println("Marca: "
                    + activo.getMarca());

            System.out.println("Modelo: "
                    + activo.getModelo());

            System.out.println("Valor: $"
                    + activo.getValor());

            System.out.println("Costo mantenimiento: $"
                    + mantenimiento);


            System.out.println("------------------------------------");


            valorTotal += activo.getValor();

            costoMantenimientoTotal += mantenimiento;

        }


        System.out.println("\nTOTAL DE ACTIVOS: "
                + activos.size());

        System.out.println("VALOR TOTAL ACTIVOS: $"
                + valorTotal);

        System.out.println("COSTO TOTAL MANTENIMIENTO: $"
                + costoMantenimientoTotal);


        System.out.println("====================================");

    }

}