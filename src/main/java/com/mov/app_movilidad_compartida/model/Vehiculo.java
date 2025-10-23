
package com.mov.app_movilidad_compartida.model;

public class Vehiculo {
    private String modelo;
    private String placa;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public boolean validarPlaca (){
        return placa != null && placa.matches("[A-Z]{3}-\\d{3}");
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "modelo=" + modelo + ", placa=" + placa + '}';
    }
    
}

