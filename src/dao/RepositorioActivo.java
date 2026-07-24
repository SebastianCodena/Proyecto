/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SebastianCodena
 */
import interfaces.IRespositorio;
import modelo.Activo;

public class RepositorioActivo {

    private final IRespositorio<Activo> repositorio;

    public RepositorioActivo() {
        this.repositorio = new ActivoDao();
    }

    public IRespositorio<Activo> getRepositorio() {
        return repositorio;
    }

}