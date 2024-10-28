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

    public static void mostrarMenuBiblioteca() {
        System.out.println("=== MENÚ BIBLIOTECA ===");
        System.out.println("1. Añadir canción a favoritos");
        System.out.println("2. Eliminar canción de favoritos");
        System.out.println("3. Ver canciones favoritas");
        System.out.println("4. Crear nueva playlist");
        System.out.println("5. Añadir canción a playlist");
        System.out.println("6. Eliminar canción de playlist");
        System.out.println("7. Ver playlists");
        System.out.println("8. Ver canciones de una playlist");
        System.out.println("9. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public static void manejarOpcionBiblioteca(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Añadir canción a favoritos.");
               
                break;
            case 2:
                System.out.println("Eliminar canción de favoritos.");
               
                break;
            case 3:
                System.out.println("Ver canciones favoritas.");
                
                break;
            case 4:
                System.out.println("Crear nueva playlist.");
                
                break;
            case 5:
                System.out.println("Añadir canción a playlist.");
                
                break;
            case 6:
                System.out.println("Eliminar canción de playlist.");
                
                break;
            case 7:
                System.out.println("Ver playlists.");
                
                break;
            case 8:
                System.out.println("Ver canciones de una playlist.");
                
                break;
            case 9:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void manejarOpcion(int opcion) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Opción de Reproducción seleccionada.");
               
                break;
            case 2:
                int opcionBiblioteca = 0;
                while (opcionBiblioteca != 9) {
                    mostrarMenuBiblioteca();
                    opcionBiblioteca = scanner.nextInt();
                    manejarOpcionBiblioteca(opcionBiblioteca);
                }
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
        if (opcion == 3){
            System.out.println("Gracias por usar Spotify");
            scanner.close();
        }

        scanner.close();
    }
}