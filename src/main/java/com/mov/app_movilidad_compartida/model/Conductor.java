package com.mov.app_movilidad_compartida.model;

public class Conductor {

    private String DNI; 
    private String nombre;
    private String licencia;
    private String correoInstitucional;
    private String contrasena;

    public Conductor(String DNI, String nombre, String licencia, String correoInstitucional, String contrasena) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.licencia = licencia;
        this.correoInstitucional = correoInstitucional;
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

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Conductor() {
    }

   
   

    // Validar que el correo sea institucional
    public boolean validarCorreoInstitucional() {
        return correoInstitucional != null &&
               (correoInstitucional.endsWith("@usil.pe") || correoInstitucional.endsWith("@usil.edu.pe"));
    }

} 