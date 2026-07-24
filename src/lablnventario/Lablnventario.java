/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lablnventario;

/**
 *
 * @author SebastianCodena
 */
import controlador.ActivoController;
import dao.ActivoDao;
import interfaces.IRespositorio;
import modelo.Activo;
import servicio.ActivoService;
import interfaces.IActivoService;
import servicio.ServicioMantenimiento;
import vista.Consola;
public class Lablnventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Repositorio
        IRespositorio<Activo> repositorio = new ActivoDao();

        // Servicios
        IActivoService activoService = new ActivoService(repositorio);
        ServicioMantenimiento mantenimientoService = new ServicioMantenimiento();

        // Controlador
        ActivoController controller =
                new ActivoController(activoService, mantenimientoService);

        // Vista
        Consola consola = new Consola(controller);

        // Iniciar aplicación
        consola.iniciar();

    }

}