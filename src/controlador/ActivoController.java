/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author SebastianCodena
 */
import java.util.List;
import modelo.Activo;
import interfaces.IActivoService;
import interfaces.IMantenimientoService;
import interfaces.IReporteService;
import servicio.ReporteService;

public class ActivoController {

    private final IActivoService activoService;
    private final IMantenimientoService mantenimientoService;
    private final IReporteService reporteService;

    public ActivoController(IActivoService activoService,
                            IMantenimientoService mantenimientoService,IReporteService reporteService) {

        this.activoService = activoService;
        this.mantenimientoService = mantenimientoService;
        this.reporteService = reporteService;

    }

    public boolean guardarActivo(Activo activo){

        return activoService.guardar(activo);

    }

    public boolean actualizarActivo(Activo activo){

        return activoService.actualizar(activo);

    }

    public boolean eliminarActivo(int id){

        return activoService.eliminar(id);

    }

    public Activo buscarActivo(int id){

        return activoService.buscarPorId(id);

    }

    public List<Activo> listarActivos(){

        return activoService.listar();

    }

    public double calcularCostoTotal(){

        return mantenimientoService.calcularCostoTotal(
                activoService.listar());

    }

 
  
    public void mostrarReporte(){

    reporteService.generarReporte();

}

}