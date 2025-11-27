package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RutaService {

    private static RutaService instancia;
    private List<Ruta> rutas = new ArrayList<>();
    private VehiculoService vehiculoService;
    
    private RutaService() { }

    public static RutaService getInstance() {
        if (instancia == null) {
            instancia = new RutaService();
        }
        return instancia;
    }
    
    public List<Ruta> getRutasDisponiblesParaEstudiante(Estudiante e) {
        List<Ruta> disponibles = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.estaDisponible() && !r.getEstudiantes().contains(e)) {
                disponibles.add(r);
            }
        }
        return disponibles;
    }

    public Ruta buscarRutaPorId(String id) {
        for (Ruta r : rutas) {
            if (r.getIdRuta().equals(id)) return r;
        }
        return null;
    }

    private RutaService() {
        this.rutas = new ArrayList<>();
    }
    
    public static RutaService getInstance() {
        if (instancia == null) {
            instancia = new RutaService();
        }
        return instancia;
    }

    public void setVehiculoService(VehiculoService vehiculoService) { this.vehiculoService = vehiculoService; }

    public void registrarRuta(Ruta ruta) {
        if (ruta == null) return;
        for (Ruta r : rutas) {
            if (r.getIdRuta().equalsIgnoreCase(ruta.getIdRuta())) return;
        }
        rutas.add(ruta);
    }

    public Ruta createRuta(Scanner sc, Conductor conductor, VehiculoService vehiculoService) {
        System.out.print("ID Ruta: ");
        String id = sc.nextLine();
        System.out.print("Origen: ");
        String origen = sc.nextLine();
        System.out.print("Destino: ");
        String destino = sc.nextLine();
        System.out.print("Hora de salida: ");
        String hora = sc.nextLine();
        System.out.print("Aforo maximo: ");
        int aforo = Integer.parseInt(sc.nextLine());
        System.out.print("Costo por estudiante: ");
        double costo = Double.parseDouble(sc.nextLine());
        Vehiculo vehiculo = vehiculoService.seleccionarVehiculoPorConsola(sc);
        if (vehiculo == null) return null;
        Ruta r = new Ruta(id, origen, destino, hora, aforo, costo, conductor, vehiculo);
        return r;
    }

    public void listarRutasDisponibles() {
        boolean found = false;
        for (Ruta r : rutas) {
            if (r.estaDisponible()) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("No hay rutas disponibles");
    }

    public void registrarEstudianteEnRuta(Scanner sc, Estudiante estudiante) {
        System.out.print("ID de la ruta: ");
        String id = sc.nextLine();
        Ruta r = buscarRutaPorId(id);
        if (r == null) {
            System.out.println("Ruta no encontrada");
            return;
        }
        if (!r.estaDisponible()) {
            System.out.println("Ruta sin disponibilidad");
            return;
        }
        if (r.agregarEstudiante(estudiante)) {
            System.out.println("Registrado en la ruta");
        } else {
            System.out.println("No fue posible registrarse en la ruta");
        }
    }

    public List<Ruta> getRutasPorEstudiante(Estudiante estudiante) {
        List<Ruta> resultado = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.getEstudiantes().contains(estudiante)) resultado.add(r);
        }
        return resultado;
    }
    
    public List<Ruta> getRutasDisponibles() {
    List<Ruta> disponibles = new ArrayList<>();
    for (Ruta r : rutas) {
        if (r.estaDisponible()) {
            disponibles.add(r);
        }
    }
    return disponibles;
    }

    public void verRutasPorConductor(Conductor conductor) {
        boolean found = false;
        for (Ruta r : rutas) {
            if (r.getConductor() != null && r.getConductor().equals(conductor)) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) System.out.println("El conductor no tiene rutas asignadas");
    }

    public List<Ruta> getRutasPorConductor(Conductor conductor) {
        List<Ruta> resultado = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.getConductor() != null && r.getConductor().equals(conductor)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public void verPasajerosPorConductor(Conductor conductor) {
        boolean found = false;
        for (Ruta r : rutas) {
            if (r.getConductor() != null && r.getConductor().equals(conductor)) {
                System.out.println("Ruta " + r.getIdRuta());
                for (Estudiante e : r.getEstudiantes()) {
                    System.out.println(e.getNombre() + " - " + e.getCodigo());
                }
                found = true;
            }
        }
        if (!found) System.out.println("No hay pasajeros registrados");
    }
    
    public List<Ruta> listarRutasPorConductor(Conductor conductor) {
        List<Ruta> resultado = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.getConductor() != null && r.getConductor().equals(conductor)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

}
