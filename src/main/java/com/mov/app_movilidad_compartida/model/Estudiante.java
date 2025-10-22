package com.mov.app_movilidad_compartida.model;

public class Estudiante {
    
    private String codigo;
    private String nombre;
    private String carrera;
    private String correoInstitucional;
    private String contrasena;

    public Estudiante() {
    }

    
    public Estudiante(String codigo, String nombre, String carrera, String correoInstitucional, String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.correoInstitucional = correoInstitucional;
        this.contrasena = contrasena;
    }
    
    public boolean validarCorreoInstitucional() {
        return correoInstitucional.endsWith("@usil.pe")|| correoInstitucional.endsWith("@usil.edu.pe");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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

    @Override
    public String toString() {
        return "Estudiante{" + 
                "codigo=" + codigo + 
                ", nombre=" + nombre + 
                ", carrera=" + carrera + 
                ", correoInstitucional=" + correoInstitucional + "}";
    }
    
    
}
