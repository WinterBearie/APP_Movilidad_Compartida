package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.util.GestorArchivos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RutaService {
    private static RutaService instancia;
    private List<Ruta> rutas = new ArrayList<>();

    private GestorArchivos gestor = new GestorArchivos();
    private static final String ARCHIVO = "rutas.txt";
    private static final String ARCHIVO2 = "rutas_estudiante.txt";

    private RutaService() { }

    public static RutaService getInstance() {
        if (instancia == null) {
            instancia = new RutaService();
        }
        return instancia;
    }

    public void registrarRuta(Ruta ruta) {
        if (ruta == null)
            return;

        for (Ruta r : rutas) {
            if (r.getIdRuta().equalsIgnoreCase(ruta.getIdRuta()))
                return;
        }
        rutas.add(ruta);
        guardar();
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
        if (vehiculo == null)
            return null;
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
        if (!found)
            System.out.println("No hay rutas disponibles");
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

        guardarRelacion();
    }

    public List<Ruta> getRutasPorEstudiante(Estudiante estudiante) {
        List<Ruta> resultado = new ArrayList<>();
        for (Ruta r : rutas) {
            if (r.getEstudiantes().contains(estudiante))
                resultado.add(r);
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
        if (!found)
            System.out.println("El conductor no tiene rutas asignadas");
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
        if (!found)
            System.out.println("No hay pasajeros registrados");
    }

    public void guardar() {
        gestor.guardar(ARCHIVO, rutas, r -> r.getIdRuta() + ";" +
                r.getPuntoPartida() + ";" +
                r.getDestino() + ";" +
                r.getHoraSalida() + ";" +
                r.getAforoMaximo() + ";" +
                r.getCosto() + ";" +
                (r.getConductor() != null ? r.getConductor().getDni() : "") + ";" +
                (r.getVehiculo() != null ? r.getVehiculo().getPlaca() : ""));
    }

    public void guardarRelacion() {
        gestor.guardar(ARCHIVO2, rutas, r -> {
            StringBuilder sb = new StringBuilder();
            sb.append(r.getIdRuta());
            for (Estudiante e : r.getEstudiantes()) {
                sb.append(";").append(e.getCodigo());
            }
            return sb.toString();
        });
    }

    public void cargar(ConductorService conductorService,
            VehiculoService vehiculoService,
            EstudianteService estudianteService) {

        gestor.cargar(ARCHIVO, line -> {
            String[] p = line.split(";");
            if (p.length == 8) {
                Conductor c = conductorService.buscarPorDni(p[6]);
                if (c == null) {
                    return null;
                }

                Vehiculo v = vehiculoService.buscarPorPlaca(p[7]);
                if (v == null) {
                    return null;
                }

                Ruta r = new Ruta(
                        p[0],
                        p[1],
                        p[2],
                        p[3],
                        Integer.parseInt(p[4]),
                        Double.parseDouble(p[5]),
                        c,
                        v);

                if (buscarRutaPorId(r.getIdRuta()) == null) {
                    rutas.add(r);
                }
            }
            return null;
        });

        gestor.cargar(ARCHIVO2, line -> {
            String[] p = line.split(";");
            if (p.length >= 1) {
                Ruta r = buscarRutaPorId(p[0]);
                if (r == null) {
                    return null;
                }
                for (int i = 1; i < p.length; i++) {
                    Estudiante e = estudianteService.buscarPorCodigo(p[i]);
                    if (e != null) {
                        r.agregarEstudiante(e);
                    }
                }
            }
            return null;
        });
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
