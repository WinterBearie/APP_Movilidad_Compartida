package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Viaje;
import java.util.ArrayList;
import java.util.List;

public class ViajeService {

    private List<Viaje> listaViajes = new ArrayList<>();

    public void registrarViaje(Viaje v) { if (v != null) listaViajes.add(v); }
    
    public List<Viaje> listarViajes() { return listaViajes; }
    
    public Viaje buscarPorId(int id) { for (Viaje v : listaViajes) if (v.getIdViaje() == id) return v; return null; }
    
    public void iniciarViaje(int id) { Viaje v = buscarPorId(id); if (v != null) v.iniciarViaje(); }
    
    public void finalizarViaje(int id) { Viaje v = buscarPorId(id); if (v != null) v.finalizarViaje(); }
}
