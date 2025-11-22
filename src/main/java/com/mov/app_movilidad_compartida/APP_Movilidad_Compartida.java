package com.mov.app_movilidad_compartida;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.ConductorService;
import com.mov.app_movilidad_compartida.service.EstudianteService;
import com.mov.app_movilidad_compartida.service.RutaService;
import com.mov.app_movilidad_compartida.service.VehiculoService;
import java.util.Scanner;

public class APP_Movilidad_Compartida {
    private static final Scanner sc = new Scanner(System.in);
    private static final EstudianteService estudianteService = new EstudianteService();
    private static final ConductorService conductorService = new ConductorService();
    private static final RutaService rutaService = new RutaService();
    private static final VehiculoService vehiculoService = new VehiculoService();

    static {
        estudianteService.setRutaService(rutaService);
        rutaService.setVehiculoService(vehiculoService);
    }

    public static void main(String[] args) {
        int opcionPrincipal;
        do {
            System.out.println("\n Organiza tu ruta, equilibra tu mente");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {
                case 1 -> registrarMenu();
                case 2 -> iniciarMenu();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcionPrincipal != 3);
        sc.close();
    }

    private static void registrarMenu() {
        int opcionRegistro;
        do {
            System.out.println("\nRegistro de Usuario");
            System.out.println("1. Estudiante");
            System.out.println("2. Conductor");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opcion: ");
            opcionRegistro = sc.nextInt();
            sc.nextLine();

            switch (opcionRegistro) {
                case 1 -> registrarEstudiante();
                case 2 -> registrarConductor();
                case 3 -> System.out.println("Volviendo al menu principal...");
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcionRegistro != 3);
    }

    private static void iniciarMenu() {
        int opcionSesion;
        do {
            System.out.println("\nInicio de Sesion de Usuario");
            System.out.println("1. Estudiante");
            System.out.println("2. Conductor");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opcion: ");
            opcionSesion = sc.nextInt();
            sc.nextLine();

            switch (opcionSesion) {
                case 1 -> iniciarSesionEstudiante();
                case 2 -> iniciarSesionConductor();
                case 3 -> System.out.println("Volviendo al menu principal...");
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcionSesion != 3);
    }

    private static void registrarEstudiante() {
        boolean registroExitoso = false;
        while (!registroExitoso) {
            Estudiante nuevo = estudianteService.crearEstudiantePorConsola(sc);
            if (estudianteService.registrarEstudiante(nuevo)) {
                registroExitoso = true;
                System.out.println("Registro exitoso! Volviendo al menu principal...");
            } else {
                System.out.println("Registro fallido. Intente nuevamente.");
            }
        }
    }

    private static void registrarConductor() {
        boolean registroExitoso = false;
        while (!registroExitoso) {
            Conductor nuevoConductor = conductorService.crearConductorPorConsola(sc);
            if (conductorService.registrarConductor(nuevoConductor)) {
                registroExitoso = true;
                System.out.println("Registro exitoso! Volviendo al menu principal...");
            } else {
                System.out.println("Registro fallido. Intente nuevamente.");
            }
        }
    }

    private static void iniciarSesionEstudiante() {
        boolean sesionExitosa = false;
        while (!sesionExitosa) {
            System.out.print("\nCorreo institucional: ");
            String correo = sc.nextLine();
            System.out.print("Contrasena: ");
            String contrasena = sc.nextLine();
            Estudiante estudiante = estudianteService.iniciarSesionEstudiante(correo, contrasena);
            if (estudiante != null) {
                System.out.println("Inicio de sesion exitoso. Bienvenido, " + estudiante.getNombre() + "!");
                menuEstudiante(sc, estudiante);
                sesionExitosa = true;
            } else {
                System.out.println("Correo o contrasena incorrectos. Intente nuevamente.");
            }
        }
    }

    private static void iniciarSesionConductor() {
        boolean sesionExitosa = false;
        while (!sesionExitosa) {
            System.out.print("\nCorreo: ");
            String correo = sc.nextLine();
            System.out.print("Contrasena: ");
            String contrasena = sc.nextLine();
            Conductor conductor = conductorService.iniciarSesionConductor(correo, contrasena);
            if (conductor != null) {
                System.out.println("Inicio de sesion exitoso. Bienvenido, " + conductor.getNombre() + "!");
                menuConductor(sc, conductor);
                sesionExitosa = true;
            } else {
                System.out.println("Correo o contrasena incorrectos. Intente nuevamente.");
            }
        }
    }

    private static void menuEstudiante(Scanner sc, Estudiante estudiante) {
        int opcionEst;
        do {
            System.out.println("\nMenu del Estudiante");
            System.out.println("1. Ver rutas disponibles");
            System.out.println("2. Registrarse en una ruta");
            System.out.println("3. Ver mis viajes");
            System.out.println("4. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            opcionEst = sc.nextInt();
            sc.nextLine();

            switch (opcionEst) {
                case 1 -> rutaService.listarRutasDisponibles();
                case 2 -> rutaService.registrarEstudianteEnRuta(sc, estudiante);
                case 3 -> estudianteService.consultarRutasInscritas(estudiante);
                case 4 -> estudianteService.cerrarSesionEstudiante(estudiante);
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcionEst != 4);
    }

    private static void menuConductor(Scanner sc, Conductor conductor) {
        int opcionCond;
        do {
            System.out.println("\nMenu del Conductor");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Crear ruta");
            System.out.println("3. Ver rutas asignadas");
            System.out.println("4. Ver vehiculos registrados");
            System.out.println("5. Ver pasajeros por ruta");
            System.out.println("6. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            opcionCond = sc.nextInt();
            sc.nextLine();

            switch (opcionCond) {
                case 1 -> {
                    System.out.println("\nRegistro de Vehiculo");
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Placa (Ejm: ABC-123): ");
                    String placa = sc.nextLine();
                    vehiculoService.registrarVehiculo(modelo, tipo, placa);
                }
                case 2 -> {
                    Ruta ruta = rutaService.createRuta(sc, conductor, vehiculoService);
                    if (ruta != null) rutaService.registrarRuta(ruta);
                }
                case 3 -> rutaService.verRutasPorConductor(conductor);
                case 4 -> vehiculoService.listarVehiculos();
                case 5 -> rutaService.verPasajerosPorConductor(conductor);
                case 6 -> conductorService.cerrarSesionConductor(conductor);
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcionCond != 6);
    }
}
