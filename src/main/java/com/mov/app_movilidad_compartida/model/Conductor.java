package com.mov.app_movilidad_compartida.model;

public class Conductor extends Persona implements IReporte{

    private String dni;
    private String licencia;

    public Conductor() { }

    public Conductor(String dni, String nombre, String licencia, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        this.dni = dni;
        this.licencia = licencia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }


    @Override
    public boolean validarIdentificacion() {
        if (licencia == null) return false;
        return licencia.toUpperCase().compareTo("AIIA") >= 0;
    }

    @Override
    public String toString() {
        return "Conductor{" + "dni=" + dni + ", nombre=" + nombre + ", licencia=" + licencia + '}';
    }
    
    @Override
public String generarReporte() {
    return "-----------Reporte del Conductor-----------\n" +
           "Nombre            : " + getNombre() + "\n" +
           "DNI               : " + getDni() + "\n" +
           "Licencia          : " + getLicencia() + "\n" +
           "Licencia válida   : " + (validarIdentificacion() ? "Sí" : "No") + "\n" +
           "-------------------------------------------\n";
}


    @Override
    public void imprimir() {
        System.out.println(generarReporte());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conductor conductor = (Conductor) obj;
        return correo != null && correo.equalsIgnoreCase(conductor.correo);
    }
    
    @Override
    public int hashCode() {
        return correo != null ? correo.toLowerCase().hashCode() : 0;
    }
}
