package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class VehiculoService {
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    public boolean registrarVehiculo(String modelo, String placa) {
        if (buscarPorPlaca(placa) != null) {
            System.out.println("Error: la placa ya se encuentra registrada.");
            return false;
        }
        Vehiculo v = new Vehiculo(modelo, placa);
        
        if (!v.validarPlaca()) {
            System.out.println("Formato de placa inválido. Ejemplo correcto: ABC-123");
            return false;
        }

        listaVehiculos.add(v);
        System.out.println("Vehículo registrado correctamente: " + v);
        return true;
        }
    
        public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
        public void listarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            System.out.println("\n--- Lista de Vehículos ---");
            for (Vehiculo v : listaVehiculos) {
                System.out.println(v);
            }
        }
    }
        public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
        }
}
