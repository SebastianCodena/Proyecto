/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.List;

public interface IRespositorio<T> {

    boolean guardar(T objeto);

    boolean actualizar(T objeto);

    boolean eliminar(int id);

    T buscarPorId(int id);

    List<T> listar();

}