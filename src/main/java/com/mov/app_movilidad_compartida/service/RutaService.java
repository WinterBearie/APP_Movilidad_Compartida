package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RutaService {
    public RutaService() {
    }

    private List<Ruta> rutas = new ArrayList<>();

    public Ruta createRuta(Scanner scanner, Conductor conductor, VehiculoService vehiculoService) {
        System.out.println("\nRegistro de Ruta para Conductor: " + conductor.getDNI());

        System.out.print("ID de la ruta: ");
        int idRuta = Integer.parseInt(scanner.nextLine());

        System.out.print("Partida: ");
        String puntoPartida = scanner.nextLine();

        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.print("Hora de salida (HH:MM): ");
        String horaSalida = scanner.nextLine();

        System.out.print("Aforo maximo: ");
        int aforoMaximo = Integer.parseInt(scanner.nextLine());

        System.out.print("Costo por estudiante: ");
        double costo = Double.parseDouble(scanner.nextLine());

        List<Vehiculo> vehiculos = vehiculoService.getListaVehiculos();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados. Debe registrar un vehiculo primero.");
            return null;
        }

        System.out.println("\nSeleccione un vehiculo:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i));
        }
        System.out.print("Ingrese el numero del vehiculo: ");
        int opcionVehiculo = Integer.parseInt(scanner.nextLine());
        
        if (opcionVehiculo < 1 || opcionVehiculo > vehiculos.size()) {
            System.out.println("Opcion de vehiculo invalida.");
            return null;
        }

        Vehiculo vehiculoSeleccionado = vehiculos.get(opcionVehiculo - 1);
        Ruta ruta = new Ruta(idRuta, puntoPartida, destino, horaSalida, aforoMaximo, costo, conductor, vehiculoSeleccionado);
        return ruta;
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
        if (disponibles.isEmpty()) {
            System.out.println("No hay rutas disponibles.");
            return;
        }
        
        for (int i = 0; i < disponibles.size(); i++) {
            Ruta ruta = disponibles.get(i);
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

            System.out.println((i + 1) + ". ID: " + ruta.getIdRuta() + ", Partida: " + ruta.getPuntoPartida() +
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
        System.out.print("Seleccione el numero de ruta: ");
        int opcionSeleccionada = Integer.parseInt(scanner.nextLine());

        if (opcionSeleccionada < 1 || opcionSeleccionada > disponibles.size()) {
            System.out.println("Numero de ruta no valido.");
            return;
        }

        Ruta rutaSeleccionada = disponibles.get(opcionSeleccionada - 1);

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

        if (tieneConflictoHorario(estudiante, rutaSeleccionada.getHoraSalida())) {
            System.out.println("No puede registrarse en esta ruta porque ya tiene una ruta a la misma hora: " + rutaSeleccionada.getHoraSalida());
            return;
        }

        rutaSeleccionada.agregarEstudiante(estudiante);
        System.out.println("Estudiante " + estudiante.getCodigo() +
                " registrado en la ruta " + rutaSeleccionada.getIdRuta() + " exitosamente.");
    }

    private boolean tieneConflictoHorario(Estudiante estudiante, String nuevaHora) {
        for (Ruta ruta : rutas) {
            for (Estudiante e : ruta.getEstudiantes()) {
                if (e.getCodigo().equals(estudiante.getCodigo()) && ruta.getHoraSalida().equals(nuevaHora)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printRutasPorConductor(Conductor conductor) {
        List<Ruta> rutasConductor = getRutasPorConductor(conductor);
        if (rutasConductor.isEmpty()) {
            System.out.println("El conductor no tiene rutas registradas: DNI " + conductor.getDNI());
            return;
        }

        System.out.println("\nRutas del Conductor DNI: " + conductor.getDNI());
        for (Ruta ruta : rutasConductor) {
            System.out.println("ID: " + ruta.getIdRuta() + ", Partida: " + ruta.getPuntoPartida() +
                    ", Destino: " + ruta.getDestino() + ", Hora Salida: " + ruta.getHoraSalida() +
                    ", Costo: " + ruta.getCosto() + ", Aforo Maximo: " + ruta.getAforoMaximo() +
                    ", Estudiantes Registrados: " + ruta.getEstudiantes().size() +
                    ", Vehiculo: " + ruta.getVehiculo().getModelo() + " - " + ruta.getVehiculo().getPlaca());
        }
    }

    public void printPasajerosPorConductor(Conductor conductor) {
        List<Ruta> rutasConductor = getRutasPorConductor(conductor);
        if (rutasConductor.isEmpty()) {
            System.out.println("El conductor no tiene rutas registradas: DNI " + conductor.getDNI());
            return;
        }

        System.out.println("\nPasajeros por Ruta - Conductor: " + conductor.getNombre());
        for (Ruta ruta : rutasConductor) {
            System.out.println("\nRuta ID: " + ruta.getIdRuta() + " - " + ruta.getPuntoPartida() + " a " + ruta.getDestino());
            if (ruta.getEstudiantes().isEmpty()) {
                System.out.println("  No hay pasajeros registrados");
            } else {
                for (Estudiante estudiante : ruta.getEstudiantes()) {
                    System.out.println("  - " + estudiante.getNombre() + " (" + estudiante.getCodigo() + ")");
                }
            }
        }
    }

    private List<Ruta> getRutasPorConductor(Conductor conductor) {
        List<Ruta> rutasConductor = new ArrayList<>();
        for (Ruta ruta : rutas) {
            if (ruta.getConductor().getDNI().equals(conductor.getDNI())) {
                rutasConductor.add(ruta);
            }
        }
        return rutasConductor;
    }

    public void printRutasPorEstudiante(Estudiante estudiante) {
        System.out.println("\nMis Rutas Inscritas - " + estudiante.getNombre() + " (" + estudiante.getCodigo() + ")");
        boolean encontrado = false;
        for (Ruta ruta : rutas) {
            for (Estudiante e : ruta.getEstudiantes()) {
                if (e.getCodigo().equals(estudiante.getCodigo())) {
                    System.out.println("ID: " + ruta.getIdRuta() + 
                            ", Partida: " + ruta.getPuntoPartida() + 
                            ", Destino: " + ruta.getDestino() + 
                            ", Hora Salida: " + ruta.getHoraSalida() + 
                            ", Costo: S/" + ruta.getCosto() +
                            ", Conductor: " + ruta.getConductor().getNombre() +
                            ", Vehiculo: " + ruta.getVehiculo().getModelo() + " (" + ruta.getVehiculo().getPlaca() + ")");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No esta registrado en ninguna ruta.");
        }
    }
}