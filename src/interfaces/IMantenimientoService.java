/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author SebastianCodena
 */
import java.util.List;
import modelo.Activo;

public interface IMantenimientoService {

    double calcularCostoTotal(List<Activo> activos);

}
