package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.util.GestorArchivos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConductorService {

    private static ConductorService instancia;
    private List<Conductor> conductores = new ArrayList<>();

    private GestorArchivos gestor = new GestorArchivos();
    private static final String ARCHIVO = "conductores.txt";

    private ConductorService() {
        this.conductores = new ArrayList<>();
        this.gestor = new GestorArchivos();
    }

    public static ConductorService getInstance() {
        if (instancia == null) {
            instancia = new ConductorService();
        }
        return instancia;
    }

    public Conductor crearConductorPorConsola(Scanner sc) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Licencia: ");
        String licencia = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = sc.nextLine();

        Conductor c = new Conductor(dni, nombre, licencia, correo, contrasena);
        if (!c.validarIdentificacion()) {
            System.out.println("Licencia invalida");
            return null;
        }
        return c;
    }

    public boolean registrarConductor(Conductor conductor) {
        if (conductor == null) return false;
        if (buscarPorCorreo(conductor.getCorreo()) != null) return false;
        conductores.add(conductor);
        guardar();
        System.out.println();
        conductor.imprimir();
        return true;
    }

    public Conductor buscarPorCorreo(String correo) {
        for (Conductor c : conductores) {
            if (c.getCorreo().equalsIgnoreCase(correo)) return c;
        }
        return null;
    }

    public Conductor buscarPorDni(String dni) {
        for (Conductor c : conductores) {
            if (c.getDni().equalsIgnoreCase(dni)) return c;
        }
        return null;
    }

    public boolean asociarVehiculoAConductor(Conductor conductor, Vehiculo vehiculo) {
        if (conductor == null || vehiculo == null) return false;
        conductor.setVehiculo(vehiculo);
        guardar();
        return true;
    }

    public Conductor buscarPorPlacaVehiculo(String placa) {
        for (Conductor c : conductores) {
            if (c.getVehiculo() != null && c.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return c;
            }
        }
        return null;
    }

    public Conductor iniciarSesionConductor(String correo, String contrasena) {
        Conductor c = buscarPorCorreo(correo);
        if (c != null && c.getContrasena().equals(contrasena)) return c;
        return null;
    }

    public void cerrarSesionConductor(Conductor conductor) { }

    public void guardar() {
        gestor.guardar(ARCHIVO, conductores, c ->
            c.getDni() + ";" +
            c.getNombre() + ";" +
            c.getLicencia() + ";" +
            c.getCorreo() + ";" +
            c.getContrasena() + ";" +
            (c.getVehiculo() != null ? c.getVehiculo().getPlaca() : "")
        );
    }

    public void cargar(VehiculoService vehiculoService) {
        gestor.cargar(ARCHIVO, line -> {
            String[] p = line.split(";");
            // System.out.println("Cargando conductor: " + line + " partes: " + p.length);
            if (p.length >= 5) {
                Conductor c = new Conductor(p[0], p[1], p[2], p[3], p[4]);
                if (buscarPorCorreo(c.getCorreo()) == null) {
                    conductores.add(c);
                }

                if (p.length < 6) return null;

                String placaVehiculo = p[5];
                if (vehiculoService != null && placaVehiculo != null && !placaVehiculo.isEmpty()) {
                    Vehiculo v = vehiculoService.buscarPorPlaca(placaVehiculo);
                    if (v != null) {
                        c.setVehiculo(v);
                    }
                }
            }
            return null;
        });
        System.out.println("Conductores cargados: " + conductores.size());
    }
}
