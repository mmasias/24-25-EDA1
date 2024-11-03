package entregas.nevesKelvia.Reto_004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Biblioteca");
            System.out.println("2. Reproducción");
            System.out.println("3. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
            } else if (opcion == 2) {
                int opcionReproduccion = 0;
                do {
                    System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
                    System.out.println("1. Ver canción actual");
                    System.out.println("2. Reproducir siguiente");
                    System.out.println("3. Ver cola de reproducción");
                    System.out.println("4. Ver historial");
                    System.out.println("5. Volver al menú principal");

                    System.out.print("Seleccione una opción: ");
                    opcionReproduccion = scanner.nextInt();
                    scanner.nextLine();

                    if (opcionReproduccion == 1) {
                        reproductor.verCancionActual();
                    } else if (opcionReproduccion == 2) {
                        reproductor.reproducirSiguiente();
                    } else if (opcionReproduccion == 3) {
                        reproductor.verColaReproduccion();
                    } else if (opcionReproduccion == 4) {
                        reproductor.mostrarHistorial();
                    } else if (opcionReproduccion != 5) {
                        System.out.println("Opción inválida, intente de nuevo.");
                    }
                } while (opcionReproduccion != 5);
            } else if (opcion != 3) {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
