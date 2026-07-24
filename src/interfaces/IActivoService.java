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

public interface IActivoService {

    boolean guardar(Activo activo);

    boolean actualizar(Activo activo);

    boolean eliminar(int id);

    Activo buscarPorId(int id);

    List<Activo> listar();

}