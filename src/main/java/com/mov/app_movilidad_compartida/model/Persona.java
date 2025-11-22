package com.mov.app_movilidad_compartida.model;

public abstract class Persona {

    protected String nombre;
    protected String correo;
    protected String contrasena;

    public Persona() {
    }

    public Persona(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    

    public abstract boolean validarIdentificacion();

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
    
    
}
