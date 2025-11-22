package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Conductor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConductorService {

    private List<Conductor> conductores = new ArrayList<>();

    public Conductor crearConductorPorConsola(Scanner sc) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Licencia: ");
        String licencia = sc.nextLine();
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = sc.nextLine();

        Conductor c = new Conductor(dni, nombre, licencia, correo, contrasena);
        if (!c.validarIdentificacion()) {
            System.out.println("Licencia invalida");
            return null;
        }
        return c;
    }

    public boolean registrarConductor(Conductor conductor) {
        if (conductor == null) return false;
        if (buscarPorCorreo(conductor.getCorreo()) != null) return false;
        conductores.add(conductor);
        return true;
    }

    public Conductor buscarPorCorreo(String correo) {
        for (Conductor c : conductores) {
            if (c.getCorreo().equalsIgnoreCase(correo)) return c;
        }
        return null;
    }

    public Conductor iniciarSesionConductor(String correo, String contrasena) {
        Conductor c = buscarPorCorreo(correo);
        if (c != null && c.getContrasena().equals(contrasena)) return c;
        return null;
    }

    public void cerrarSesionConductor(Conductor conductor) { }
}
