package com.mov.app_movilidad_compartida;

import com.mov.app_movilidad_compartida.model.Conductor;
import com.mov.app_movilidad_compartida.model.Estudiante;
import com.mov.app_movilidad_compartida.model.Ruta;
import com.mov.app_movilidad_compartida.service.EstudianteService;
import com.mov.app_movilidad_compartida.service.RutaService;
import com.mov.app_movilidad_compartida.service.VehiculoService;
import java.util.Scanner;

public class APP_Movilidad_Compartida {
    private static final Scanner sc = new Scanner(System.in);
    private static final EstudianteService estudianteService = new EstudianteService();
    private static final RutaService rutaService = new RutaService();
    private static final VehiculoService vehiculoService = new VehiculoService();

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
                case 1 -> {
                    int opcionRegistro;
                    do {
                        System.out.println("\nRegistro de Usuario");
                        System.out.println("1. Estudiante");
                        System.out.println("2. Conductor");
                        System.out.println("3. Regresar al menu principal");
                        System.out.print("Seleccione una opcion: ");
                        opcionRegistro = sc.nextInt();
                        sc.nextLine();

                        switch (opcionRegistro) {
                            case 1 -> {
                                Estudiante nuevo = estudianteService.crearEstudiantePorConsola(sc);
                                estudianteService.registrarEstudiante(nuevo);
                            }
                            case 2 -> {
                                System.out.println("\nRegistro de Conductor");
                                System.out.println("(Soon...)");
                            }
                            case 3 -> System.out.println("Volviendo al menu principal...");
                            default -> System.out.println("Opcion invalida, intente nuevamente.");
                        }
                    } while (opcionRegistro != 3);
                }

                case 2 -> {
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
                            case 1 -> {
                                System.out.print("\nCorreo institucional: ");
                                String correo = sc.nextLine();

                                System.out.print("Contrasena: ");
                                String contrasena = sc.nextLine();

                                Estudiante estudiante = estudianteService.iniciarSesionEstudiante(correo, contrasena);

                                if (estudiante != null) {
                                    System.out.println(
                                            "Inicio de sesion exitoso. Bienvenid@, " + estudiante.getNombre() + "!");
                                    menuEstudiante(sc, estudiante);
                                } else {
                                    System.out.println("Correo o contrasena incorrectos.");
                                }
                            }
                            case 2 -> {
                                System.out.println("\nInicio de Sesion de Conductor");
                                System.out.println("(Soon...)");
                            }
                            case 3 -> System.out.println("Volviendo al menu principal...");
                            default -> System.out.println("Opcion invalida, intente nuevamente.");
                        }
                    } while (opcionSesion != 3);
                }

                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }

        } while (opcionPrincipal != 3);

        sc.close();
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
                case 1 -> rutaService.printRutasDisponibles(estudiante);
                case 2 -> rutaService.registrarEstudianteEnRuta(sc, estudiante);
                case 3 -> estudianteService.consultarRutasInscritas();
                case 4 -> estudianteService.cerrarSesionEstudiante(estudiante);
                default -> System.out.println("Opcion invalida, intente nuevamente.");
            }

        } while (opcionEst != 4);
    }

    private static void menuConductor(Scanner sc, Conductor conductor) {
        int opcionEst;
        do {
            System.out.println("\nMenu del Conductor");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Registrarse en una ruta");
            System.out.println("3. Ver mis rutas y pasajeros");
            System.out.println("4. Ver vehiculos registrados");
            System.out.println("5. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            opcionEst = sc.nextInt();
            sc.nextLine();

            switch (opcionEst) {
                case 1 -> {
                    System.out.println("\n Registro de Vehiculo");
                    System.out.print("Ingrese modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Ingrese placa (formato ABC-123): ");
                    String placa = sc.nextLine();
                    vehiculoService.registrarVehiculo(modelo, placa);
                }
                case 2 -> {
                    Ruta ruta = rutaService.createRuta(sc, conductor);
                    rutaService.registrarRuta(ruta);
                }
                
                case 3 -> {
                    System.out.println("\n Vehiculos Registrados");
                    vehiculoService.listarVehiculos();
                }    
                case 4 -> rutaService.printRutasPorConductor(conductor);   
                default -> System.out.println("Opcion invalida, intente nuevamente.");
        }

        } while (opcionEst != 4);
    }
}
