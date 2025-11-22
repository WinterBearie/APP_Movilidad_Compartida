package com.mov.app_movilidad_compartida.model;

public class Viaje {

    private int idViaje;
    private Ruta ruta;
    private String estado;

    public Viaje(int idViaje, Ruta ruta) {
        this.idViaje = idViaje;
        this.ruta = ruta;
        this.estado = "Pendiente";
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void iniciarViaje() { estado = "En curso"; }
    public void finalizarViaje() { estado = "Finalizado"; }

    @Override
    public String toString() {
        return "Viaje{" + "idViaje=" + idViaje + ", ruta=" + (ruta != null ? ruta.getIdRuta() : "N/A") + ", estado='" + estado + '\'' + '}';
    }
}
