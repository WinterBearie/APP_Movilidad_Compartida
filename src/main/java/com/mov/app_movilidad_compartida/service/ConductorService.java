package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConductorService {

    private List<Conductor> conductores = new ArrayList<>();

    // Registrar un nuevo conductor
    public void registrarConductor(Conductor conductor) {
        if (conductor == null) return;
        if (conductor.validarCorreoInstitucional()) {
            if (!verificarCorreoRepetido(conductor.getCorreoInstitucional())) {
                conductores.add(conductor);
                System.out.println("Registro exitoso para: " + conductor.getNombre());
            } else {
                System.out.println("El correo ya está registrado.");
            }
        } else {
            System.out.println("El correo debe ser institucional (@usil.pe o @usil.edu.pe)");
        }
    }

    // Crear conductor desde consola
    public Conductor crearConductorPorConsola(Scanner sc) {
        System.out.println("\nRegistro de Conductor"); 
        System.out.print("DNI: ");
        String DNI = sc.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Licencia: ");
        String licencia = sc.nextLine();

        System.out.print("Correo institucional: ");
        String correo = sc.nextLine();

        System.out.print("Contrasena: ");
        String contrasena = sc.nextLine();

        return new Conductor(DNI , nombre, licencia, correo, contrasena);
    }

    // Evitar correos duplicados
    public boolean verificarCorreoRepetido(String correo) {
        for (Conductor c : conductores) {
            if (c.getCorreoInstitucional().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    // Iniciar sesión
    public Conductor iniciarSesionConductor(String correo, String contrasena) {
        for (Conductor c : conductores) {
            if (c.getCorreoInstitucional().equals(correo) && c.getContrasena().equals(contrasena)) {
                return c;
            }
        }
        return null;
    }

    // Cerrar sesión
    public void cerrarSesionConductor(Conductor conductor) {
        System.out.println("Sesion cerrada. Hasta pronto, " + conductor.getNombre() + "!");
    }
}
