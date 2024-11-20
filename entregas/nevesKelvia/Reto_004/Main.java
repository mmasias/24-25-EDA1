package entregas.nevesKelvia.Reto_004;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();

        biblioteca.añadirCancion(new Cancion("Dead in the water", "James Gillespie", 258));
        biblioteca.añadirCancion(new Cancion("Always been you", "Chris Grey", 234));
        biblioteca.añadirCancion(new Cancion("Bad Habits", "Ed Sheeran", 285));
        biblioteca.añadirCancion(new Cancion("Stay For A While", "Victor Ray", 342));
        biblioteca.añadirCancion(new Cancion("My Home", "Myles Smith", 295));
        biblioteca.añadirCancion(new Cancion("O Sol e a Lua", "Pequeno Cidadao", 238));
        biblioteca.añadirCancion(new Cancion("Night Dancer", "Imase", 243));
        biblioteca.añadirCancion(new Cancion("I'd Rather Pretend", "Bryant Barnes", 266));
        biblioteca.añadirCancion(new Cancion("It's You", "Ali Gatie", 235));
        biblioteca.añadirCancion(new Cancion("I Wanna Be Yours", "Artic Monkeys", 325));
        biblioteca.añadirCancion(new Cancion("All Of Me", "Jonh Legend", 325));
        biblioteca.añadirCancion(new Cancion("Left Of Me", "Johnny Huynh", 325));

        boolean salir = false;

        while (!salir) {
            System.out.println("=== SPOTIFY ===");
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionPrincipal = scanner.nextInt();
            scanner.nextLine();

            if (opcionPrincipal == 1) {
                menuReproduccion(scanner, reproductor, biblioteca);
            } else if (opcionPrincipal == 2) {
                menuBiblioteca(scanner, biblioteca);
            } else if (opcionPrincipal == 3) {
                salir = true;
                System.out.println("Saliendo de Spotify. ¡Hasta luego!");
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void menuBiblioteca(Scanner scanner, Biblioteca biblioteca) {
        boolean volver = false;

        while (!volver) {
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
            int opcionBiblioteca = scanner.nextInt();
            scanner.nextLine();

            if (opcionBiblioteca == 1) {
                System.out.println("Seleccione canción para añadir a favoritos:");
                biblioteca.mostrarCanciones();
                int cancionFavoritaIndex = scanner.nextInt() - 1;
                biblioteca.añadirAFavoritos(biblioteca.getCanciones().obtener(cancionFavoritaIndex));
            } else if (opcionBiblioteca == 2) {
                System.out.println("Seleccione canción para eliminar de favoritos:");
                biblioteca.mostrarFavoritas();
                int cancionFavoritaEliminarIndex = scanner.nextInt() - 1;
                biblioteca.eliminarDeFavoritos(biblioteca.getCancionesFavoritas().obtener(cancionFavoritaEliminarIndex));
            } else if (opcionBiblioteca == 3) {
                biblioteca.mostrarFavoritas();
            } else if (opcionBiblioteca == 4) {
                System.out.print("Nombre de la nueva playlist: ");
                String nombrePlaylist = scanner.nextLine();
                biblioteca.crearPlaylist(nombrePlaylist);
            } else if (opcionBiblioteca == 5) {
                System.out.println("Playlists disponibles:");
                biblioteca.obtenerPlaylists().mostrarElementos();
                System.out.print("Seleccione playlist: ");
                int playlistIndex = scanner.nextInt() - 1;
                Playlist playlist = biblioteca.obtenerPlaylists().obtener(playlistIndex);
                biblioteca.mostrarCanciones();
                System.out.print("Seleccione canción a añadir: ");
                int cancionPlaylistIndex = scanner.nextInt() - 1;
                playlist.añadirCancion(biblioteca.getCanciones().obtener(cancionPlaylistIndex));
            } else if (opcionBiblioteca == 9) {
                volver = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuReproduccion(Scanner scanner, Reproductor reproductor, Biblioteca biblioteca) {
        boolean volver = false;

        while (!volver) {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Ver cola de reproducción");
            System.out.println("4. Activar/desactivar aleatorio");
            System.out.println("5. Activar/desactivar repetición");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcionReproduccion = scanner.nextInt();
            scanner.nextLine();

            if (opcionReproduccion == 1) {
                if (reproductor.getCancionActual() == null) {
                    System.out.println("No hay canción en reproducción.");
                    System.out.print("¿Desea comenzar a reproducir? (S/N): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("S")) {
                        biblioteca.mostrarCanciones();
                        System.out.print("Seleccione canción (1-" + biblioteca.getCanciones().tamaño() + "): ");
                        int seleccionCancion = scanner.nextInt() - 1;
                        reproductor.añadirACola(biblioteca.getCanciones().obtener(seleccionCancion));
                        reproductor.reproducir();
                    }
                } else {
                    System.out.println("Canción en reproducción: " + reproductor.getCancionActual());
                }
            } else if (opcionReproduccion == 2) {
                reproductor.siguiente();
            } else if (opcionReproduccion == 3) {
                reproductor.getColaReproduccion().mostrarElementos();
            } else if (opcionReproduccion == 4) {
                reproductor.activarAleatorio();
            } else if (opcionReproduccion == 5) {
                reproductor.activarRepetir();
            } else if (opcionReproduccion == 6) {
                volver = true;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
