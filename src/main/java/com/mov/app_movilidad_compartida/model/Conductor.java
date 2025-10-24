package com.mov.app_movilidad_compartida.model;

public class Conductor {

    private String DNI; 
    private String nombre;
    private String licencia;
    private String correo;
    private String contrasena;

    public Conductor(String DNI, String nombre, String licencia, String correo, String contrasena) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.licencia = licencia;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Conductor() {
    }

    public boolean validarLicencia() {
        if (licencia == null) return false;
        String licenciaUpper = licencia.toUpperCase();
        return licenciaUpper.compareTo("AIIA") >= 0;
    }

}