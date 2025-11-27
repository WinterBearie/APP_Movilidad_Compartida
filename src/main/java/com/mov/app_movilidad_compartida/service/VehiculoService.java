package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Vehiculo;
import com.mov.app_movilidad_compartida.util.GestorArchivos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiculoService {

    private static VehiculoService instancia;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    private GestorArchivos gestor = new GestorArchivos();
    private static final String ARCHIVO = "vehiculos.txt";

    private VehiculoService() {
        this.vehiculos = new ArrayList<>();
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
        vehiculos.add(v);
        guardar();
        System.out.println("Vehiculo registrado correctamente: " + v);
        return true;
    }

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca() != null && v.getPlaca().equalsIgnoreCase(placa))
                return v;
        }
        return null;
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos)
            System.out.println(v);
    }

    public Vehiculo seleccionarVehiculoPorConsola(Scanner sc) {
        if (vehiculos.isEmpty())
            return null;
        System.out.println("Vehículos disponibles:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i));
        }
        System.out.print("Seleccione vehículo (número): ");
        int idx;
        try {
            idx = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return null;
        }
        if (idx < 1 || idx > vehiculos.size())
            return null;
        return vehiculos.get(idx - 1);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void guardar() {
        gestor.guardar(ARCHIVO, vehiculos, v -> v.getModelo() + ";" + v.getTipo() + ";" + v.getPlaca());
    }

    public void cargar() {
        gestor.cargar(ARCHIVO, line -> {
            String[] p = line.split(";");
            if (p.length == 3) {
                Vehiculo v = new Vehiculo(p[0], p[1], p[2]);
                if (buscarPorPlaca(v.getPlaca()) == null) {
                    vehiculos.add(v);
                }
            }
            return null;
        });
    }
}
