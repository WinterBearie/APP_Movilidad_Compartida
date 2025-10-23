package com.mov.app_movilidad_compartida.model;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private int idRuta;
    private String puntoPartida;
    private String destino;
    private String horaSalida;
    private int aforoMaximo;
    private double costo;
    private Conductor conductor;
    private List<Estudiante> estudiantes;

    public Ruta(int idRuta, String puntoPartida, String destino, String horaSalida, int aforoMaximo, double costo,
            Conductor conductor) {
        this.idRuta = idRuta;
        this.puntoPartida = puntoPartida;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.aforoMaximo = aforoMaximo;
        this.costo = costo;
        this.conductor = conductor;
        this.estudiantes = new ArrayList<>();
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
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

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < aforoMaximo) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes, aforo máximo alcanzado.");
        }
    }

    public boolean estaDisponible() {
        return estudiantes.size() < aforoMaximo;
    }


    @Override
    public String toString() {
        return "Ruta{" +
                "idRuta=" + idRuta +
                ", puntoPartida='" + puntoPartida + '\'' +
                ", destino='" + destino + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", aforoMaximo=" + aforoMaximo +
                ", costo=" + costo +
                ", conductor=" + conductor +
                ", estudiantes=" + estudiantes +
                '}';
    }

}
