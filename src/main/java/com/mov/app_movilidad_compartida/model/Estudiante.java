package com.mov.app_movilidad_compartida.model;

public class Estudiante extends Persona implements IReporte {

    private String codigo;
    private String carrera;

    public Estudiante() { }

    public Estudiante(String codigo, String nombre, String carrera, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public boolean validarIdentificacion() {
        if (correo == null) return false;
        String c = correo.toLowerCase();
        return c.endsWith("@usil.pe") || c.endsWith("@usil.edu.pe");
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigo=" + codigo + ", nombre=" + nombre + ", correo=" + correo + '}';
    }
    
    @Override
    public String generarReporte() {
        return "-----------Reporte del Estudiante ----------\n" +
               "Nombre            : " + getNombre() + "\n" +
               "Código            : " + getCodigo() + "\n" +
               "Correo            : " + getCorreo() + "\n" +
               "Carrera           : " + getCarrera() + "\n" +
               "Correo válido     : " + (getCorreo() != null && getCorreo().contains("@") ? "Sí" : "No") + "\n" +
               "-------------------------------------------\n";
}

    @Override
    public void imprimir() {
        System.out.println(generarReporte());
    }
}
