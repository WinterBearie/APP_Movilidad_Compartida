package com.mov.app_movilidad_compartida.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private int idViaje;
    private Ruta ruta;
    private Conductor conductor;
    private List<Estudiante> pasajeros;
    private String fecha;
    private boolean enCurso;

    public Viaje(int idViaje, Ruta ruta, Conductor conductor, String fecha) {
        this.idViaje = idViaje;
        this.ruta = ruta;
        this.conductor = conductor;
        this.fecha = fecha;
        this.enCurso = false;
        this.pasajeros = new ArrayList<>();
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Estudiante> getPasajeros() {
        return pasajeros;
    }

    public void agregarPasajero(Estudiante estudiante) {
        if (ruta.estaDisponible()) {
            pasajeros.add(estudiante);
            ruta.agregarEstudiante(estudiante);
        } else {
            System.out.println("El viaje no tiene asientos disponibles.");
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEnCurso() {
        return enCurso;
    }

    public void iniciarViaje() {
        enCurso = true;
        System.out.println("El viaje ha iniciado.");
    }

    public void finalizarViaje() {
        enCurso = false;
        System.out.println("El viaje ha finalizado.");
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "idViaje=" + idViaje +
                ", ruta=" + ruta +
                ", conductor=" + conductor +
                ", pasajeros=" + pasajeros +
                ", fecha='" + fecha + '\'' +
                ", enCurso=" + enCurso +
                '}';
    }
}