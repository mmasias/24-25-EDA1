import java.util.Scanner;
public class Spotify {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cancion cancion1 = new Cancion("titulo1", "artista1", 230);
        Cancion cancion2 = new Cancion("titulo2", "artista1", 220);
        Cancion cancion3 = new Cancion("titulo3", "artista1", 210);
        Cancion cancion4 = new Cancion("titulo4", "artista1", 200);
        Cancion cancion5 = new Cancion("titulo5", "artista1", 190);
        Cancion cancion6 = new Cancion("titulo6", "artista1", 180);
        Lista biblioteca = new Lista();
        System.out.println(cancion1.toString());
        System.out.println(cancion2.toString());
        System.out.println(cancion3.toString());
        System.out.println(cancion4.toString());
        System.out.println(cancion5.toString());
        System.out.println(cancion6.toString());
        biblioteca.anadirCancion(cancion1);
        biblioteca.anadirCancion(cancion2);
        biblioteca.anadirCancion(cancion3);
        biblioteca.anadirCancion(cancion4);
        biblioteca.anadirCancion(cancion5);
        biblioteca.anadirCancion(cancion6);

        System.out.println("=== SPOTIFY ===");
        System.out.println();
        System.out.println("BIBLIOTECA INICIAL");
        System.out.println();
        System.out.println("Canciones disponibles:");
        System.out.println();
        biblioteca.mostrarCanciones();
        System.out.println();
        
        boolean salir = false;

        do{
            limpiarPantalla();
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Reproduccion");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            int opcionPrincipal = scanner.nextInt();
            switch (opcionPrincipal) {
                case 1:
                    limpiarPantalla();
                    menuReproduccion(scanner);
                    break;
                case 2:
                    limpiarPantalla();
                    menuBiblioteca(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("Elige una opcion valida");
            }
        } while (!salir);
        
    }

    private static void menuReproduccion(Scanner scanner){
        int opcionReproduccion;
        do {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial");
            System.out.println("6. Activar/desactivar aleatorio");
            System.out.println("7. Activar/desactivar repetición");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionReproduccion = scanner.nextInt();

            switch (opcionReproduccion) {
                case 1:
                    System.out.println("Mostrando canción actual...");
                    break;
                case 2:
                    System.out.println("Reproduciendo siguiente canción...");
                    break;
                case 3:
                    System.out.println("Reproduciendo canción anterior...");
                    break;
                case 4:
                    System.out.println("Mostrando cola de reproducción...");
                    break;
                case 5:
                    System.out.println("Mostrando historial de reproducción...");
                    break;
                case 6:
                    System.out.println("Aleatorio activado/desactivado...");
                    break;
                case 7:
                    System.out.println("Repetición activada/desactivada...");
                    break;
                case 8:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionReproduccion != 8);
    }

    private static void menuBiblioteca(Scanner scanner){
        int opcionBiblioteca;
        do {
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
            opcionBiblioteca = scanner.nextInt();

            switch (opcionBiblioteca) {
                case 1:
                    System.out.println("Añadiendo canción a favoritos...");
                    break;
                case 2:
                    System.out.println("Eliminando canción de favoritos...");
                    break;
                case 3:
                    System.out.println("Mostrando canciones favoritas...");
                    break;
                case 4:
                    System.out.println("Creando nueva playlist...");
                    break;
                case 5:
                    System.out.println("Añadiendo canción a playlist...");
                    break;
                case 6:
                    System.out.println("Eliminando canción de playlist...");
                    break;
                case 7:
                    System.out.println("Mostrando playlists...");
                    break;
                case 8:
                    System.out.println("Mostrando canciones de una playlist...");
                    break;
                case 9:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionBiblioteca != 9);
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
