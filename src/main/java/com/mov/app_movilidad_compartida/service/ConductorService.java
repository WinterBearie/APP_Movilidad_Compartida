package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.util.GestorArchivos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConductorService {

    private static ConductorService instancia;
    private List<Conductor> conductores;
    private GestorArchivos gestor;
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
        System.out.println("Conductor registrado:");
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
        conductor.getVehiculos().add(vehiculo);
        vehiculo.setConductor(conductor);
        guardar();
        return true;
    }


    public List<Vehiculo> getVehiculosPorConductor(Conductor conductor, VehiculoService vehiculoService) {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : vehiculoService.getVehiculos()) {
            if (v.getConductor() != null && v.getConductor().equals(conductor)) {
                lista.add(v);
            }
        }
        return lista;
    }

    public Conductor buscarPorPlacaVehiculo(String placa) {
        for (Conductor c : conductores) { 
            for (Vehiculo v : c.getVehiculos()) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    return c;
                }
            }
        }
        return null;
    }

    public Conductor iniciarSesionConductor(String correo, String contrasena) {
        Conductor c = buscarPorCorreo(correo);
        if (c != null && c.getContrasena().equals(contrasena)) return c;
        return null;
    }

    public void cerrarSesionConductor(Conductor conductor) { 
        
    }

    
    public void guardar() {
    gestor.guardar(ARCHIVO, conductores, con -> {
        String placas = con.getVehiculos().isEmpty() ? "" :
                         String.join(",", con.getVehiculos().stream().map(Vehiculo::getPlaca).toList());
        return con.getDni() + ";" +
               con.getNombre() + ";" +
               con.getLicencia() + ";" +
               con.getCorreo() + ";" +
               con.getContrasena() + ";" +
               placas;
    });

    }

    public void cargar(VehiculoService vehiculoService) {
    gestor.cargar(ARCHIVO, line -> {
        String[] p = line.split(";");
        if (p.length >= 5) {
            Conductor c = new Conductor(p[0], p[1], p[2], p[3], p[4]);
            if (buscarPorCorreo(c.getCorreo()) == null) {
                conductores.add(c);
            }

            if (p.length >= 6 && !p[5].isEmpty()) {
                String[] placas = p[5].split(",");
                for (String placa : placas) {
                    Vehiculo v = vehiculoService.buscarPorPlaca(placa);
                    if (v != null) {
                        c.getVehiculos().add(v);
                        v.setConductor(c);
                    }
                }
            }
        }
        return null;
    });
    System.out.println("Conductores cargados: " + conductores.size());
}
}
