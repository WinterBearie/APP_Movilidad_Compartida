package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private RutaService rutaService;

    public boolean registrarEstudiante(Estudiante estudiante) {
        if (estudiante.validarCorreoInstitucional()) {
            if (!verificarCorreoRepetido(estudiante.getCorreoInstitucional())) {
                estudiantes.add(estudiante);
                System.out.println("Registro exitoso para: " + estudiante.getNombre());
                return true;
            } else {
                System.out.println("El correo ya esta registrado.");
                return false;
            }
        } else {
            System.out.println("El correo debe ser institucional (@usil.pe o @usil.edu.pe)");
            return false;
        }
    }

    public Estudiante crearEstudiantePorConsola(Scanner sc) {
        System.out.println("\nRegistro de Estudiante");
        System.out.print("Codigo de estudiante: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Carrera: ");
        String carrera = sc.nextLine();

        System.out.print("Correo institucional: ");
        String correo = sc.nextLine();

        System.out.print("Contrasena: ");
        String contrasena = sc.nextLine();

        return new Estudiante(codigo, nombre, carrera, correo, contrasena);
    }

    public boolean validarCorreoInstitucional(String correo) {
        return correo.toLowerCase().endsWith("@usil.pe") || correo.toLowerCase().endsWith("@usil.edu.pe");
    }

    public boolean verificarCorreoRepetido(String correo) {
        for (Estudiante e : estudiantes) {
            if (e.getCorreoInstitucional().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }

    public Estudiante iniciarSesionEstudiante(String correo, String contrasena) {
        for (Estudiante e : estudiantes) {
            if (e.getCorreoInstitucional().equalsIgnoreCase(correo) && e.getContrasena().equals(contrasena)) {
                return e;
            }
        }
        return null;
    }

    public void consultarRutasInscritas(Estudiante estudiante) {
        if (rutaService != null) {
            rutaService.printRutasPorEstudiante(estudiante);
        } else {
            System.out.println("Error: Servicio de rutas no disponible.");
        }
    }

    public void setRutaService(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    public void cerrarSesionEstudiante(Estudiante estudiante) {
        System.out.println("Sesion cerrada. Hasta pronto, " + estudiante.getNombre() + "!");
    }
}