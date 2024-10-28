package Reto004;

import java.util.Scanner;

public class Spotify {

    public static void mostrarMenu() {
        System.out.println("=== MENÚ PRINCIPAL ===");
        System.out.println("1. Reproducción");
        System.out.println("2. Biblioteca");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Opción de Reproducción seleccionada.");
                // Aquí puedes agregar la lógica para la opción de Reproducción
                break;
            case 2:
                System.out.println("Opción de Biblioteca seleccionada.");
                // Aquí puedes agregar la lógica para la opción de Biblioteca
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            mostrarMenu();
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        }

        scanner.close();
    }
}