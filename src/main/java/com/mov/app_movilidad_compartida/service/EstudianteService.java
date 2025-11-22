package com.mov.app_movilidad_compartida.service;

import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>();
    private RutaService rutaService;

    public void setRutaService(RutaService rutaService) { this.rutaService = rutaService; }

    public Estudiante crearEstudiantePorConsola(Scanner sc) {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine();
        System.out.print("Correo institucional: ");
        String correo = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        Estudiante e = new Estudiante(codigo, nombre, carrera, correo, contrasena);
        if (!e.validarIdentificacion()) {
            System.out.println("Correo institucional inválido");
            return null;
        }
        return e;
    }

    public boolean registrarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        if (buscarPorCorreo(estudiante.getCorreo()) != null) return false;
        estudiantes.add(estudiante);
        return true;
    }

    public Estudiante buscarPorCorreo(String correo) {
        for (Estudiante e : estudiantes) {
            if (e.getCorreo().equalsIgnoreCase(correo)) return e;
        }
        return null;
    }

    public Estudiante iniciarSesionEstudiante(String correo, String contrasena) {
        Estudiante e = buscarPorCorreo(correo);
        if (e != null && e.getContrasena().equals(contrasena)) return e;
        return null;
    }

    public void cerrarSesionEstudiante(Estudiante estudiante) { }

    public void consultarRutasInscritas(Estudiante estudiante) {
        if (rutaService == null) {
            System.out.println("Error: servicio de rutas no disponible");
            return;
        }
        List<Ruta> rutas = rutaService.getRutasPorEstudiante(estudiante);
        if (rutas == null || rutas.isEmpty()) {
            System.out.println("No tiene rutas inscritas");
            return;
        }
        for (Ruta r : rutas) System.out.println(r);
    }
}
