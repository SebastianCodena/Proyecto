/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author SebastianCodena
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionSQLite {


    private static final String URL =
            "jdbc:sqlite:db/LabInventario.db";


    public static Connection conectar() throws SQLException {

        Connection con = DriverManager.getConnection(URL);

        System.out.println("Base conectada correctamente");

        return con;

    }

}