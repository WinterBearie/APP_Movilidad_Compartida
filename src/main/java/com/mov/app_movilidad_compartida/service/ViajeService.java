package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Viaje;
import java.util.ArrayList;
import java.util.List;

public class ViajeService {
    private List<Viaje> listaViajes;

    public ViajeService() {
        listaViajes = new ArrayList<>();
    }

    public void registrarViaje(Viaje viaje) {
        listaViajes.add(viaje);
    }

    public List<Viaje> listarViajes() {
        return listaViajes;
    }

    public Viaje buscarPorId(int idViaje) {
        for (Viaje v : listaViajes) {
            if (v.getIdViaje() == idViaje) {
                return v;
            }
        }
        return null;
    }

    public void eliminarViaje(int idViaje) {
        listaViajes.removeIf(v -> v.getIdViaje() == idViaje);
    }

    public void iniciarViaje(int idViaje) {
        Viaje v = buscarPorId(idViaje);
        if (v != null) {
            v.iniciarViaje();
        }
    }

    public void finalizarViaje(int idViaje) {
        Viaje v = buscarPorId(idViaje);
        if (v != null) {
            v.finalizarViaje();
        }
    }
}