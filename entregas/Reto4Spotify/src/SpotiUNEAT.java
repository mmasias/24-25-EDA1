import java.util.Scanner;

public class SpotiUNEAT {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();
    private static SistemaReproduccion sistemaReproduccion = new SistemaReproduccion();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Biblioteca");
            System.out.println("2. Reproducción");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> menuBiblioteca();
                case 2 -> menuReproduccion();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private static void menuBiblioteca() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Ver todas las canciones");
            System.out.println("2. Añadir canción a favoritos");
            System.out.println("3. Eliminar canción de favoritos");
            System.out.println("4. Ver canciones favoritas");
            System.out.println("5. Crear nueva playlist");
            System.out.println("6. Añadir canción a playlist");
            System.out.println("7. Eliminar canción de playlist");
            System.out.println("8. Ver playlists");
            System.out.println("9. Ver canciones de una playlist");
            System.out.println("10. Añadir canción a la cola de reproducción");
            System.out.println("11. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> biblioteca.mostrarCanciones();
                case 2 -> {
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione la canción a añadir a favoritos (índice): ");
                    int indice = scanner.nextInt();
                    Cancion cancion = biblioteca.canciones.obtener(indice - 1);
                    if (cancion != null) {
                        biblioteca.agregarFavorito(cancion);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 3 -> {
                    biblioteca.verFavoritos();
                    System.out.print("Seleccione la canción a eliminar de favoritos (índice): ");
                    int indice = scanner.nextInt();
                    Cancion cancion = biblioteca.favoritas.obtener(indice - 1);
                    if (cancion != null) {
                        biblioteca.eliminarFavorito(cancion);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 4 -> biblioteca.verFavoritos();
                case 5 -> {
                    System.out.print("Nombre de la nueva playlist: ");
                    scanner.nextLine();
                    String nombrePlaylist = scanner.nextLine();
                    biblioteca.crearPlaylist(nombrePlaylist);
                }
                case 6 -> {
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione playlist (índice): ");
                    int indicePlaylist = scanner.nextInt();
                    Playlist playlist = biblioteca.playlists.obtener(indicePlaylist - 1);

                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione canción para añadir (índice): ");
                    int indiceCancion = scanner.nextInt();
                    Cancion cancion = biblioteca.canciones.obtener(indiceCancion - 1);

                    biblioteca.agregarCancionAPlaylist(playlist, cancion);
                }
                case 7 -> {
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione playlist (índice): ");
                    int indicePlaylist = scanner.nextInt();
                    Playlist playlist = biblioteca.playlists.obtener(indicePlaylist - 1);

                    playlist.verCanciones();
                    System.out.print("Seleccione canción para eliminar (índice): ");
                    int indiceCancion = scanner.nextInt();
                    Cancion cancion = playlist.obtenerCancion(indiceCancion - 1);

                    biblioteca.eliminarCancionDePlaylist(playlist, cancion);
                }
                case 8 -> biblioteca.verPlaylists();
                case 9 -> {
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione playlist (índice): ");
                    int indicePlaylist = scanner.nextInt();
                    Playlist playlist = biblioteca.playlists.obtener(indicePlaylist - 1);
                    biblioteca.verCancionesDePlaylist(playlist);
                }
                case 10 -> {
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione la canción a añadir a la cola de reproducción (índice): ");
                    int indiceCancion = scanner.nextInt();
                    Cancion cancion = biblioteca.canciones.obtener(indiceCancion - 1);
                    if (cancion != null) {
                        sistemaReproduccion.agregarACola(cancion);
                        System.out.println("Añadida a la cola de reproducción: " + cancion);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
                case 11 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 11);
    }


    private static void menuReproduccion() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial de reproducción");
            System.out.println("6. Activar/desactivar aleatorio");
            System.out.println("7. Activar/desactivar repetición");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    Cancion actual = sistemaReproduccion.getCancionActual();
                    if (actual != null) {
                        System.out.println("Canción actual: " + actual);
                    } else {
                        System.out.println("No hay canción en reproducción.");
                    }
                }
                case 2 -> sistemaReproduccion.reproducirSiguiente();
                case 3 -> sistemaReproduccion.reproducirAnterior();
                case 4 -> sistemaReproduccion.verCola();
                case 5 -> sistemaReproduccion.verHistorial();
                case 6 -> sistemaReproduccion.activarAleatorio();
                case 7 -> sistemaReproduccion.activarRepetir();
                case 8 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
}


