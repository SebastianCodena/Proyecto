/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author SebastianCodena
 */

 import dao.ActivoDao;
import modelo.Hardware;
import modelo.Activo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ActivoDaoTest {


    @Test
    public void guardarActivo(){

        ActivoDao dao = new ActivoDao();


        Hardware laptop = new Hardware(

                0,
                "Laptop Lenovo",
                "Lenovo",
                "ThinkPad",
                "2025",
                900

        );


        boolean resultado =
                dao.guardar(laptop);



        assertTrue(resultado);

    }



    @Test
    public void buscarActivo(){


        ActivoDao dao = new ActivoDao();


        Activo activo =
                dao.buscarPorId(1);



        assertNotNull(activo);



    }



    @Test
    public void listarActivos(){


        ActivoDao dao = new ActivoDao();


        assertFalse(
                dao.listar().isEmpty()
        );


    }


}