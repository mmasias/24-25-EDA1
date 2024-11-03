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
        scanner.nextLine();
        Cancion cancion = biblioteca.getCancionesDisponibles().get(numeroCancion);
        biblioteca.marcarComoFavorita(cancion);
    } 

    private void eliminarCancionDeFavoritos() {
        System.out.println("Canciones favoritas:");
        biblioteca.mostrarCancionesFavoritas();
        System.out.print("Seleccione el número de la canción a eliminar de favoritos: ");
        int numeroCancion = scanner.nextInt() - 1;
        scanner.nextLine(); 
        Cancion cancion = biblioteca.getCancionesFavoritas().get(numeroCancion);
        biblioteca.desmarcarFavorita(cancion);
    }   

    private void crearPlaylist() {
        System.out.print("Nombre de la nueva playlist: ");
        String nombre = scanner.nextLine();
        biblioteca.crearPlaylist(nombre);
    }

    private void añadirCancionAPlaylist() {
        biblioteca.mostrarPlaylists();
        System.out.print("Seleccione la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        
        System.out.println("Canciones disponibles:");
        biblioteca.mostrarCancionesDisponibles();
        System.out.print("Seleccione el número de la canción a añadir: ");
        int numeroCancion = scanner.nextInt() - 1;
        scanner.nextLine(); // limpiar buffer
        Cancion cancion = biblioteca.getCancionesDisponibles().get(numeroCancion);
        biblioteca.añadirCancionAPlaylist(nombrePlaylist, cancion);
    }

    private void eliminarCancionDePlaylist() {
        biblioteca.mostrarPlaylists();
        System.out.print("Seleccione la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        
        System.out.println("Canciones en la playlist:");
        biblioteca.mostrarCancionesDePlaylist(nombrePlaylist);
        System.out.print("Seleccione el número de la canción a eliminar: ");
        int numeroCancion = scanner.nextInt() - 1;
        scanner.nextLine(); 
        Cancion cancion = biblioteca.getPlaylists().get(nombrePlaylist).getCanciones().get(numeroCancion);
        biblioteca.eliminarCancionDePlaylist(nombrePlaylist, cancion);
    }

    private void verCancionesDePlaylist() {
        biblioteca.mostrarPlaylists();
        System.out.print("Seleccione la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        biblioteca.mostrarCancionesDePlaylist(nombrePlaylist);
    }

    private void menuReproduccion() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial");
            System.out.println("6. Activar/desactivar aleatorio");
            System.out.println("7. Activar/desactivar repetición");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> verCancionActual();
                case 2 -> reproductor.siguienteCancion();
                case 3 -> reproductor.anteriorCancion();();
                case 4 -> reproductor.verColaReproduccion();
                case 5 -> reproductor.verHistorial();
                case 6 -> toggleAleatorio();
                case 7 -> toggleRepeticion();
                case 8 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }

    private void verCancionActual() {
        Cancion cancionActual = reproductor.verCancionActual();
        if (cancionActual == null) {
            System.out.print("No hay canción en reproducción. ¿Desea comenzar a reproducir? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.println("Seleccione canción (1-" + biblioteca.getCancionesDisponibles().size() + "): ");
                int numeroCancion = scanner.nextInt() - 1;
                scanner.nextLine(); // limpiar buffer
                Cancion cancion = biblioteca.getCancionesDisponibles().get(numeroCancion);
                reproductor.reproducirCancion(cancionActual);(cancion);
            }
        } else {
            System.out.println("▶ Reproduciendo: " + cancionActual);
        }
    }


    public static void main(String[] args) {
        SpotifyApp app = new SpotifyApp();
        app.iniciar();
    }
}

