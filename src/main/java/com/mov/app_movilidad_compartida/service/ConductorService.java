package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConductorService {

    private List<Conductor> conductores = new ArrayList<>();

    public boolean registrarConductor(Conductor conductor) {
        if (conductor == null) return false;
        if (conductor.validarLicencia()) {
            if (!verificarCorreoRepetido(conductor.getCorreo())) {
                conductores.add(conductor);
                System.out.println("Registro exitoso para: " + conductor.getNombre());
                return true;
            } else {
                System.out.println("El correo ya esta registrado.");
                return false;
            }
        } else {
            System.out.println("La licencia debe ser mayor o igual a AIIa para realizar movilidad.");
            return false;
        }
    }

    public Conductor crearConductorPorConsola(Scanner sc) {
        System.out.println("\nRegistro de Conductor"); 
        System.out.print("DNI: ");
        String DNI = sc.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Licencia: ");
        String licencia = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Contrasena: ");
        String contrasena = sc.nextLine();

        return new Conductor(DNI , nombre, licencia, correo, contrasena);
    }

    public boolean verificarCorreoRepetido(String correo) {
        for (Conductor c : conductores) {
            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    public Conductor iniciarSesionConductor(String correo, String contrasena) {
        for (Conductor c : conductores) {
            if (c.getCorreo().equalsIgnoreCase(correo) && c.getContrasena().equals(contrasena)) {
                return c;
            }
        }
        return null;
    }

    public void cerrarSesionConductor(Conductor conductor) {
        System.out.println("Sesion cerrada. Hasta pronto, " + conductor.getNombre() + "!");
    }
}