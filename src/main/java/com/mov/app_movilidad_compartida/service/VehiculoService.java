package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoService {

    private static VehiculoService instancia;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    
    private VehiculoService() {
        this.listaVehiculos = new ArrayList<>();
    }
    
    public static VehiculoService getInstance() {
        if (instancia == null) {
            instancia = new VehiculoService();
        }
        return instancia;
    }

    public boolean registrarVehiculo(String modelo, String tipo, String placa) {
        if (buscarPorPlaca(placa) != null) {
            System.out.println("Error: la placa ya se encuentra registrada.");
            return false;
        }
        Vehiculo v = new Vehiculo(modelo, tipo, placa);
        if (!v.validarPlaca()) {
            System.out.println("Formato de placa invalido. Ejemplo correcto: ABC-123");
            return false;
        }
        listaVehiculos.add(v);
        System.out.println("Vehiculo registrado correctamente: " + v);
        return true;
    }

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca() != null && v.getPlaca().equalsIgnoreCase(placa)) return v;
        }
        return null;
    }

    public void listarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }
        for (Vehiculo v : listaVehiculos) System.out.println(v);
    }

    public Vehiculo seleccionarVehiculoPorConsola(Scanner sc) {
        if (listaVehiculos.isEmpty()) return null;
        System.out.println("Vehículos disponibles:");
        for (int i = 0; i < listaVehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + listaVehiculos.get(i));
        }
        System.out.print("Seleccione vehículo (número): ");
        int idx;
        try {
            idx = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return null;
        }
        if (idx < 1 || idx > listaVehiculos.size()) return null;
        return listaVehiculos.get(idx - 1);
    }

    public List<Vehiculo> getListaVehiculos() { return listaVehiculos; }
}
