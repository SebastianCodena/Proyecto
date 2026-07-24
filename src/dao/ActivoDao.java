/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author SebastianCodena
 */
import Factory.ActivoFactory;
import interfaces.IRespositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Activo;
import util.ConexionSQLite;

public class ActivoDao implements IRespositorio<Activo>{
@Override
public boolean guardar(Activo activo) {

    String sql = "INSERT INTO activo(nombre,marca,modelo,fechaCompra,valor,tipo)"
            + " VALUES(?,?,?,?,?,?)";

    try (Connection con = ConexionSQLite.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, activo.getNombre());
        ps.setString(2, activo.getMarca());
        ps.setString(3, activo.getModelo());
        ps.setString(4, activo.getFechaCompra());
        ps.setDouble(5, activo.getValor());
        ps.setString(6, activo.getClass().getSimpleName());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return false;

}
@Override
public boolean actualizar(Activo activo) {

    String sql = "UPDATE activo SET nombre=?,marca=?,modelo=?,fechaCompra=?,valor=?,tipo=? WHERE id=?";

    try(Connection con=ConexionSQLite.conectar();
        PreparedStatement ps=con.prepareStatement(sql)){

        ps.setString(1,activo.getNombre());
        ps.setString(2,activo.getMarca());
        ps.setString(3,activo.getModelo());
        ps.setString(4,activo.getFechaCompra());
        ps.setDouble(5,activo.getValor());
        ps.setString(6,activo.getClass().getSimpleName());
        ps.setInt(7,activo.getId());

        return ps.executeUpdate()>0;

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return false;

}
@Override
public boolean eliminar(int id){

    String sql="DELETE FROM activo WHERE id=?";

    try(Connection con=ConexionSQLite.conectar();
        PreparedStatement ps=con.prepareStatement(sql)){

        ps.setInt(1,id);

        return ps.executeUpdate()>0;

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return false;

}
@Override
public Activo buscarPorId(int id){

    String sql="SELECT * FROM activo WHERE id=?";

    try(Connection con=ConexionSQLite.conectar();
        PreparedStatement ps=con.prepareStatement(sql)){

        ps.setInt(1,id);

        ResultSet rs=ps.executeQuery();

        if(rs.next()){

            return crearActivo(rs);

        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return null;

}
@Override
public List<Activo> listar(){

    List<Activo> lista=new ArrayList<>();

    String sql="SELECT * FROM activo";

    try(Connection con=ConexionSQLite.conectar();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery()){

        while(rs.next()){

            lista.add(crearActivo(rs));

        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

    return lista;

}
private Activo crearActivo(ResultSet rs) throws SQLException {

    String tipo = rs.getString("tipo");

    Activo activo = ActivoFactory.crearActivo(tipo);

    activo.setId(rs.getInt("id"));
    activo.setNombre(rs.getString("nombre"));
    activo.setMarca(rs.getString("marca"));
    activo.setModelo(rs.getString("modelo"));
    activo.setFechaCompra(rs.getString("fechaCompra"));
    activo.setValor(rs.getDouble("valor"));

    return activo;

}
}