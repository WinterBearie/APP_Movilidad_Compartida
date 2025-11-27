package com.mov.app_movilidad_compartida.model;

import java.util.ArrayList;
import java.util.List;

public class Ruta {

    private String idRuta;
    private String puntoPartida;
    private String destino;
    private String horaSalida;
    private int aforoMaximo;
    private double costo;
    private Conductor conductor;
    
    private Vehiculo vehiculo;
    private List<Estudiante> estudiantes = new ArrayList<>();
    
    public Conductor getConductor() {
        return conductor;
    }

    public Ruta(String idRuta, String puntoPartida, String destino, String horaSalida, int aforoMaximo, double costo,
                Conductor conductor, Vehiculo vehiculo) {
        this.idRuta = idRuta;
        this.puntoPartida = puntoPartida;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.aforoMaximo = aforoMaximo;
        this.costo = costo;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    public List<Estudiante> getEstudiantes() { return estudiantes; }

    public Vehiculo getVehiculo() { return vehiculo; }

    public void setConductor(Conductor conductor) { this.conductor = conductor; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        if (estudiantes.size() >= aforoMaximo) return false;
        if (estudiantes.contains(estudiante)) return false;
        estudiantes.add(estudiante);
        return true;
    }

    public boolean estaDisponible() {
        return estudiantes.size() < aforoMaximo;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "idRuta='" + idRuta + '\'' +
                ", puntoPartida='" + puntoPartida + '\'' +
                ", destino='" + destino + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", aforoMaximo=" + aforoMaximo +
                ", costo=" + costo +
                ", conductor=" + (conductor != null ? conductor.getNombre() : "N/A") +
                ", vehiculo=" + (vehiculo != null ? vehiculo.getPlaca() : "N/A") +
                ", inscritos=" + estudiantes.size() +
                '}';
    }
}
