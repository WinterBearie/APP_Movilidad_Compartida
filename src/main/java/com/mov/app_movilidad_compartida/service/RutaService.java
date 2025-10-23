package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.model.Conductor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RutaService {
    public RutaService() {
    }

    private List<Ruta> rutas = new ArrayList<>();

    public Ruta createRuta(Scanner scanner, Conductor conductor) {
        System.out.println("\nRegistro de Ruta para Conductor: " + conductor.getDNI());

        System.out.print("ID de la ruta: ");
        int idRuta = Integer.parseInt(scanner.nextLine());

        System.out.print("Partida:");
        String puntoPartida = scanner.nextLine();

        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Hora de salida (HH:MM): ");
        String horaSalida = scanner.nextLine();

        System.out.print("Aforo maximo: ");
        int aforoMaximo = Integer.parseInt(scanner.nextLine());

        System.out.print("Costo por estudiante: ");
        double costo = Double.parseDouble(scanner.nextLine());

        return new Ruta(idRuta, puntoPartida, destino, horaSalida, aforoMaximo, costo, conductor);
    }

    private Ruta getRutaPorConductor(Conductor conductor) {
        for (Ruta ruta : rutas) {
            if (ruta.getConductor().getDNI().equals(conductor.getDNI())) {
                return ruta;
            }
        }
        return null;
    }

    public void registrarRuta(Ruta ruta) {
        if (ruta == null) {
            System.out.println("La ruta no puede ser nula.");
            return;
        }

        if (ruta.getAforoMaximo() <= 0) {
            System.out.println("El aforo maximo debe ser mayor a cero.");
            return;
        }

        if (ruta.getCosto() < 0) {
            System.out.println("El costo no puede ser negativo.");
            return;
        }

        if (ruta.getConductor() == null) {
            System.out.println("La ruta debe tener un conductor asociado.");
            return;
        }

        if (ruta.getHoraSalida() == null || ruta.getHoraSalida().isEmpty()) {
            System.out.println("La hora de salida es obligatoria.");
            return;
        }

        if (ruta.getPuntoPartida() == null || ruta.getPuntoPartida().isEmpty()) {
            System.out.println("El punto de partida es obligatorio.");
            return;
        }

        if (ruta.getDestino() == null || ruta.getDestino().isEmpty()) {
            System.out.println("El destino es obligatorio.");
            return;
        }

        for (Ruta r : rutas) {
            if (r.getIdRuta() == ruta.getIdRuta()) {
                System.out.println("Ya existe una ruta con el mismo ID: " + ruta.getIdRuta());
                return;
            }
            if (r.getConductor().getDNI().equals(ruta.getConductor().getDNI())) {
                System.out.println("El conductor ya tiene una ruta registrada: DNI " + ruta.getConductor().getDNI());
                return;
            }
        }

        rutas.add(ruta);
        System.out.println("Ruta registrada exitosamente: ID " + ruta.getIdRuta());
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void printRutas() {
        System.out.println("\nRutas Registradas:");
        for (Ruta ruta : rutas) {
            System.out.println("ID: " + ruta.getIdRuta() + ", Conductor DNI: " + ruta.getConductor().getDNI() +
                    ", Partida: " + ruta.getPuntoPartida() + ", Destino: " + ruta.getDestino() +
                    ", Hora Salida: " + ruta.getHoraSalida() + ", Costo: " + ruta.getCosto() +
                    ", Aforo Maximo: " + ruta.getAforoMaximo() +
                    ", Estudiantes Registrados: " + ruta.getEstudiantes().size());
        }
    }

    public List<Ruta> getRutasDisponibles() {
        List<Ruta> disponibles = new ArrayList<>();
        for (Ruta ruta : rutas) {
            if (ruta.estaDisponible()) {
                disponibles.add(ruta);
            }
        }
        return disponibles;
    }

    public void printRutasDisponibles(Estudiante estudiante) {
        List<Ruta> disponibles = getRutasDisponibles();
        System.out.println("\nRutas Disponibles:");
        for (Ruta ruta : disponibles) {
            boolean yaRegistrado = false;

            for (Estudiante e : ruta.getEstudiantes()) {
                if (e.getCodigo().equals(estudiante.getCodigo())) {
                    yaRegistrado = true;
                    break;
                }
            }

            if (yaRegistrado) {
                continue;
            }

            System.out.println("ID: " + ruta.getIdRuta() + ", Partida: " + ruta.getPuntoPartida() +
                    ", Destino: " + ruta.getDestino() + ", Hora Salida: " + ruta.getHoraSalida() +
                    ", Costo: " + ruta.getCosto() + ", Aforo Disponible: " +
                    (ruta.getAforoMaximo() - ruta.getEstudiantes().size()));
        }
    }

    public void registrarEstudianteEnRuta(Scanner scanner, Estudiante estudiante) {
        List<Ruta> disponibles = getRutasDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay rutas disponibles en este momento.");
            return;
        }

        printRutasDisponibles(estudiante);
        int idSeleccionado = Integer.parseInt(scanner.nextLine());

        Ruta rutaSeleccionada = null;
        for (Ruta ruta : disponibles) {
            if (ruta.getIdRuta() == idSeleccionado) {
                rutaSeleccionada = ruta;
                break;
            }
        }

        if (rutaSeleccionada == null) {
            System.out.println("ID de ruta no valido.");
            return;
        }

        if (!rutaSeleccionada.estaDisponible()) {
            System.out.println("La ruta no tiene disponibilidad.");
            return;
        }

        for (Estudiante e : rutaSeleccionada.getEstudiantes()) {
            if (e.getCodigo().equals(estudiante.getCodigo())) {
                System.out.println("El estudiante ya esta registrado en esta ruta: Codigo " + estudiante.getCodigo());
                return;
            }
        }

        rutaSeleccionada.agregarEstudiante(estudiante);
        System.out.println("Estudiante " + estudiante.getCodigo() +
                " registrado en la ruta " + rutaSeleccionada.getIdRuta() + " exitosamente.");
    }

    public void printRutasPorConductor(Conductor conductor) {
        Ruta ruta = getRutaPorConductor(conductor);
        if (ruta == null) {
            System.out.println("El conductor no tiene rutas registradas: DNI " + conductor.getDNI());
            return;
        }

        System.out.println("\nRuta del Conductor DNI: " + conductor.getDNI());
        System.out.println("ID: " + ruta.getIdRuta() + ", Partida: " + ruta.getPuntoPartida() +
                ", Destino: " + ruta.getDestino() + ", Hora Salida: " + ruta.getHoraSalida() +
                ", Costo: " + ruta.getCosto() + ", Aforo Maximo: " + ruta.getAforoMaximo() +
                ", Estudiantes Registrados: " + ruta.getEstudiantes().size());
    }

    public void printRutasPorEstudiante(Estudiante estudiante) {
        System.out.println("\nRutas del Estudiante Codigo: " + estudiante.getCodigo());
        boolean encontrado = false;
        for (Ruta ruta : rutas) {
            for (Estudiante e : ruta.getEstudiantes()) {
                if (e.getCodigo().equals(estudiante.getCodigo())) {
                    System.out.println("ID: " + ruta.getIdRuta() + ", Partida: " + ruta.getPuntoPartida() +
                            ", Destino: " + ruta.getDestino() + ", Hora Salida: " + ruta.getHoraSalida() +
                            ", Costo: " + ruta.getCosto());
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("El estudiante no esta registrado en ninguna ruta: Codigo " + estudiante.getCodigo());
        }
    }
}
