/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author SebastianCodena
 */
import controlador.ActivoController;
import java.util.List;
import java.util.Scanner;
import modelo.Activo;
import modelo.Hardware;
import modelo.Licencia;
import modelo.Periferico;

public class Consola {

    private final Scanner scanner;
    private final ActivoController controller;

    public Consola(ActivoController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarActivo();
                    break;

                case 2:
                    listarActivos();
                    break;

                case 3:
                    buscarActivo();
                    break;

                case 4:
                    actualizarActivo();
                    break;

                case 5:
                    eliminarActivo();
                    break;

                case 6:

                    controller.mostrarReporte();

                break;

                case 7:
                    System.out.println("\nHasta pronto...");
                    break;

                default:
                    System.out.println("\nOpción inválida.");

            }

        } while (opcion != 7);

    }

    private void mostrarMenu() {

        System.out.println("\n======================================");
        System.out.println("      LAB INVENTARIO - UTPL");
        System.out.println("======================================");
        System.out.println("1. Registrar activo");
        System.out.println("2. Listar activos");
        System.out.println("3. Buscar activo");
        System.out.println("4. Actualizar activo");
        System.out.println("5. Eliminar activo");
        System.out.println("6. Reporte mantenimiento");
        System.out.println("7. Salir");
        System.out.println("======================================");

    }

    private void registrarActivo() {

        Activo activo = crearActivo();

        if (controller.guardarActivo(activo)) {

            System.out.println("\nActivo registrado correctamente.");

        } else {

            System.out.println("\nNo se pudo registrar.");

        }

    }

    private Activo crearActivo() {

        System.out.println("\nTipo de activo");
        System.out.println("1. Hardware");
        System.out.println("2. Periferico");
        System.out.println("3. Licencia");

        System.out.print("Seleccione: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Fecha de compra: ");
        String fecha = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Activo activo;

        switch (tipo) {

            case 1:

                activo = new Hardware();
                break;

            case 2:

                activo = new Periferico();
                break;

            default:

                activo = new Licencia();

        }

        activo.setNombre(nombre);
        activo.setMarca(marca);
        activo.setModelo(modelo);
        activo.setFechaCompra(fecha);
        activo.setValor(valor);

        return activo;

    }

    private void listarActivos() {

        List<Activo> lista = controller.listarActivos();

        if (lista.isEmpty()) {

            System.out.println("\nNo existen activos.");

            return;

        }

        System.out.println("\n===== LISTADO =====");

        for (Activo activo : lista) {

            System.out.println("------------------------------");
            System.out.println("ID: " + activo.getId());
            System.out.println("Nombre: " + activo.getNombre());
            System.out.println("Marca: " + activo.getMarca());
            System.out.println("Modelo: " + activo.getModelo());
            System.out.println("Fecha: " + activo.getFechaCompra());
            System.out.println("Valor: $" + activo.getValor());
            System.out.println("Tipo: " + activo.getClass().getSimpleName());
            System.out.println("Mantenimiento: $" + activo.calcularCostoMantenimiento());

        }

    }

    private void buscarActivo() {

        System.out.print("\nIngrese el ID: ");

        int id = Integer.parseInt(scanner.nextLine());

        Activo activo = controller.buscarActivo(id);

        if (activo == null) {

            System.out.println("\nActivo no encontrado.");

            return;

        }

        System.out.println("\n===== ACTIVO =====");
        System.out.println("ID: " + activo.getId());
        System.out.println("Nombre: " + activo.getNombre());
        System.out.println("Marca: " + activo.getMarca());
        System.out.println("Modelo: " + activo.getModelo());
        System.out.println("Fecha: " + activo.getFechaCompra());
        System.out.println("Valor: $" + activo.getValor());

    }

    private void actualizarActivo() {

        System.out.print("\nIngrese el ID del activo: ");

        int id = Integer.parseInt(scanner.nextLine());

        Activo activo = controller.buscarActivo(id);

        if (activo == null) {

            System.out.println("\nActivo no encontrado.");

            return;

        }

        System.out.print("Nuevo nombre: ");
        activo.setNombre(scanner.nextLine());

        System.out.print("Nueva marca: ");
        activo.setMarca(scanner.nextLine());

        System.out.print("Nuevo modelo: ");
        activo.setModelo(scanner.nextLine());

        System.out.print("Nueva fecha: ");
        activo.setFechaCompra(scanner.nextLine());

        System.out.print("Nuevo valor: ");
        activo.setValor(Double.parseDouble(scanner.nextLine()));

        if (controller.actualizarActivo(activo)) {

            System.out.println("\nActivo actualizado.");

        } else {

            System.out.println("\nNo se pudo actualizar.");

        }

    }

    private void eliminarActivo() {

        System.out.print("\nIngrese el ID: ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.eliminarActivo(id)) {

            System.out.println("\nActivo eliminado.");

        } else {

            System.out.println("\nNo se pudo eliminar.");

        }

    }

    

}