/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author SebastianCodena
 */

import interfaces.IRespositorio;
import interfaces.IActivoService;
import java.util.List;
import modelo.Activo;

public class ActivoService implements IActivoService {

    private final IRespositorio<Activo> repositorio;

    public ActivoService(
        IRespositorio<Activo> repositorio){

    this.repositorio = repositorio;

}
    @Override
    public boolean guardar(Activo activo) {

        if (activo == null) {
            return false;
        }

        return repositorio.guardar(activo);
    }

    @Override
    public boolean actualizar(Activo activo) {

        if (activo == null) {
            return false;
        }

        return repositorio.actualizar(activo);
    }

    @Override
    public boolean eliminar(int id) {

        if (id <= 0) {
            return false;
        }

        return repositorio.eliminar(id);
    }

    @Override
    public Activo buscarPorId(int id) {

        return repositorio.buscarPorId(id);

    }

    @Override
    public List<Activo> listar() {

        return repositorio.listar();

    }

}