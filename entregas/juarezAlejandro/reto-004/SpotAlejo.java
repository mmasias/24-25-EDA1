import java.util.Scanner;

public class SpotAlejo {
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
                case 1:
                    menuBiblioteca();
                    break;
                case 2:
                    menuReproduccion();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    // Estos dos menús, lo mejor sería que se encargara la Biblioteca
    // (menuBiblioteca) y el sistemaReproduccion (menuReproduccion)
    // Por ejemplo, poner:
    /*
     * En vez de esto:
     * case 1:
     * menuBiblioteca();
     * break;
     */

    /*
     * Colocar:
     * case 1:
     * biblioteca.menu();
     * break;
     */
    // De esta manera, la biblioteca se encarga de mostrar ese menú
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
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCanciones();
                    break;
                case 2:
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione la canción a añadir a favoritos (número): ");
                    int indiceFavorito = scanner.nextInt();
                    Cancion cancionFavorita = biblioteca.canciones.obtenerCancion(indiceFavorito - 1);
                    biblioteca.agregarFavorito(cancionFavorita);
                    break;
                case 3:
                    biblioteca.verFavoritos();
                    System.out.print("Seleccione la canción a eliminar de favoritos (número): ");
                    int indiceEliminarFavorito = scanner.nextInt();
                    Cancion cancionEliminarFavorito = biblioteca.favoritas.obtenerCancion(indiceEliminarFavorito - 1);
                    biblioteca.eliminarFavorito(cancionEliminarFavorito);
                    break;
                case 4:
                    biblioteca.verFavoritos();
                    break;
                case 5:
                    System.out.print("Nombre de la nueva playlist: ");
                    String nombrePlaylist = scanner.nextLine();
                    biblioteca.crearPlaylist(nombrePlaylist);
                    break;
                case 6:
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione una playlist (número): ");
                    int indicePlaylist = scanner.nextInt();
                    Playlist playlistSeleccionada = biblioteca.playlist.obtenerPlaylist(indicePlaylist - 1);
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione una canción para añadir (número): ");
                    int indiceCancion = scanner.nextInt();
                    Cancion cancionParaPlaylist = biblioteca.canciones.obtenerCancion(indiceCancion - 1);
                    biblioteca.agregarCancionAPlaylist(playlistSeleccionada, cancionParaPlaylist);
                    break;
                case 7:
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione una playlist (número): ");
                    int indiceEliminarPlaylist = scanner.nextInt();
                    Playlist playlistEliminar = biblioteca.playlist.obtenerPlaylist(indiceEliminarPlaylist - 1);
                    playlistEliminar.mostrarCanciones();
                    System.out.print("Seleccione una canción para eliminar (número): ");
                    int indiceCancionEliminar = scanner.nextInt();
                    Cancion cancionEliminar = playlistEliminar.obtenerCancion(indiceCancionEliminar - 1);
                    biblioteca.eliminarCancionDePlaylist(playlistEliminar, cancionEliminar);
                    break;
                case 8:
                    biblioteca.verPlaylists();
                    break;
                case 9:
                    biblioteca.verPlaylists();
                    System.out.print("Seleccione una playlist (número): ");
                    int indiceVerPlaylist = scanner.nextInt();
                    Playlist playlistVer = biblioteca.playlist.obtenerPlaylist(indiceVerPlaylist - 1);
                    biblioteca.verCancionesDePlaylist(playlistVer);
                    break;
                case 10:
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione una canción para añadir a la cola de reproducción (número): ");
                    int indiceCola = scanner.nextInt();
                    Cancion cancionParaCola = biblioteca.canciones.obtenerCancion(indiceCola - 1);
                    biblioteca.agregarCancionACola(cancionParaCola);
                    break;
                case 11:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
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
                case 1:
                    Cancion actual = sistemaReproduccion.getCancionActual();
                    if (actual != null) {
                        System.out.println("Canción actual: " + actual);
                    } else {
                        System.out.println("No hay canción en reproducción.");
                    }
                    break;
                case 2:
                    sistemaReproduccion.reproducirSiguiente();
                    break;
                case 3:
                    sistemaReproduccion.reproducirAnterior();
                    break;
                case 4:
                    sistemaReproduccion.verCola();
                    break;
                case 5:
                    sistemaReproduccion.verHistorial();
                    break;
                case 6:
                    sistemaReproduccion.activarAleatorio();
                    break;
                case 7:
                    sistemaReproduccion.activarRepetir();
                    break;
                case 8:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 8);
    }
}