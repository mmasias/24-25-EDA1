package reto004;

import java.util.Scanner;

public class SpotifyApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ListaCanciones biblioteca = new ListaCanciones();
    private static ColaReproduccion colaReproduccion = new ColaReproduccion();
    private static PilaHistorial historial = new PilaHistorial();

    public static void main(String[] args) {
        inicializarBiblioteca();

        int opcionPrincipal;
        do {
            mostrarBibliotecaInicial();
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionPrincipal) {
                case 1:
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 3);
    }
}