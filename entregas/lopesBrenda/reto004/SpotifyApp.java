package entregas.lopesBrenda.reto004;

import java.util.Scanner;

public class SpotifyApp {
    private Biblioteca biblioteca;
    private Reproductor reproductor;
    private Scanner scanner;

    public SpotifyApp() {
        biblioteca = new Biblioteca();
        reproductor = new Reproductor();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== SPOTIFY ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> menuReproduccion();
                case 2 -> menuBiblioteca();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void menuBiblioteca() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
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
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> añadirCancionAFavoritos();
                case 2 -> eliminarCancionDeFavoritos();
                case 3 -> biblioteca.mostrarCancionesFavoritas();
                case 4 -> crearPlaylist();
                case 5 -> añadirCancionAPlaylist();
                case 6 -> eliminarCancionDePlaylist();
                case 7 -> biblioteca.mostrarPlaylists();
                case 8 -> verCancionesDePlaylist();
                case 9 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 9);
    }

    private void añadirCancionAFavoritos() {
        System.out.println("Canciones disponibles:");
        biblioteca.mostrarCancionesDisponibles();
        System.out.print("Seleccione el número de la canción a añadir a favoritos: ");
        int numeroCancion = scanner.nextInt() - 1;
        scanner.nextLine(); // limpiar buffer
        Cancion cancion = biblioteca.getCancionesDisponibles().get(numeroCancion);
        biblioteca.marcarComoFavorita(cancion);
    }

    private void menuReproduccion() {
        // Este método será expandido para gestionar la reproducción
    }

    public static void main(String[] args) {
        SpotifyApp app = new SpotifyApp();
        app.iniciar();
    }
}

