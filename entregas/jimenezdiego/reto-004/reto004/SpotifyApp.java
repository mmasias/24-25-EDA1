package reto004;

import java.util.Scanner;

public class SpotifyApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ListaCanciones biblioteca = new ListaCanciones();
    private static ColaReproduccion colaReproduccion = new ColaReproduccion();
    private static ListaCanciones favoritos = new ListaCanciones();
    private static PilaHistorial historial = new PilaHistorial();
    private static ListaPlaylists playlists = new ListaPlaylists();

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

    private static void inicializarBiblioteca() {
        biblioteca.agregarCancion(new Cancion("Smell like teen spirit", "Nirvana", 290));
        biblioteca.agregarCancion(new Cancion("Bleed it out", "Linkin Park", 277));
        biblioteca.agregarCancion(new Cancion("505", "Artic Monkeys", 344));
        biblioteca.agregarCancion(new Cancion("Highway to hell", "AC/DC", 392));
        biblioteca.agregarCancion(new Cancion("I was made for lovin you", "Kiss", 275));
        biblioteca.agregarCancion(new Cancion("Livin’ on a Prayer", "Bon Jovi", 222));
        biblioteca.agregarCancion(new Cancion("Immigrant Song", "Led Zeppelin", 273));
        biblioteca.agregarCancion(new Cancion("Welcome to the jungle", "Guns n Roses", 266));
        biblioteca.agregarCancion(new Cancion("American Idiot", "Green Day", 235));
        biblioteca.agregarCancion(new Cancion("Bloody Valentine", "MGK", 325));
    }

    private static void menuBiblioteca() {
        int opcionBiblioteca;
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
            opcionBiblioteca = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcionBiblioteca) {
                case 1:
                    añadirCancionAFavoritos();
                    break;
                case 2:
                    eliminarCancionDeFavoritos();
                    break;
                case 3:
                    verCancionesFavoritas();
                    break;
                case 4:
                    crearPlaylist();
                    break;
                case 5:
                    añadirCancionAPlaylist();
                    break;
                case 6:
                    eliminarCancionDePlaylist();
                    break;
                case 7:
                    verPlaylists();
                    break;
                case 8:
                    verCancionesDePlaylist();
                    break;
                case 9:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionBiblioteca != 9);
    }

    private static void añadirCancionAFavoritos() {
        System.out.println("Canciones en la biblioteca:");
        biblioteca.mostrarCanciones();
        System.out.print("Seleccione la canción para añadir a favoritos: ");
        int cancionIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        NodoCancion nodo = biblioteca.getNodo(cancionIndex);
        if (nodo != null) {
            favoritos.agregarCancion(nodo.cancion);
            System.out.println("Canción añadida a favoritos.");
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void eliminarCancionDeFavoritos() {
        System.out.println("Canciones favoritas:");
        favoritos.mostrarCanciones();
        System.out.print("Seleccione la canción para eliminar de favoritos: ");
        int cancionIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        NodoCancion nodo = favoritos.getNodo(cancionIndex);
        if (nodo != null) {
            favoritos.eliminarCancion(nodo.cancion.getTitulo());
            System.out.println("Canción eliminada de favoritos.");
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void verCancionesFavoritas() {
        System.out.println("Canciones favoritas:");
        favoritos.mostrarCanciones();
    }

    private static void crearPlaylist() {
        System.out.print("Nombre de la nueva playlist: ");
        String nombrePlaylist = scanner.nextLine();
        Playlist nuevaPlaylist = new Playlist(nombrePlaylist);
        playlists.agregarPlaylist(nuevaPlaylist);
        System.out.println("Playlist \"" + nombrePlaylist + "\" creada con éxito.");
    }

    private static void añadirCancionAPlaylist() {
        if (playlists.getTamaño() == 0) {
            System.out.println("No hay playlists disponibles. Cree una playlist primero.");
            return;
        }

        System.out.println("Playlists disponibles:");
        playlists.mostrarPlaylists();

        System.out.print("Seleccione playlist: ");
        int playlistIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Playlist selectedPlaylist = playlists.obtenerPlaylist(playlistIndex);
        if (selectedPlaylist == null) {
            System.out.println("Playlist no válida.");
            return;
        }

        System.out.println("Canciones disponibles:");
        biblioteca.mostrarCanciones();
        System.out.print("Seleccione canción a añadir: ");
        int cancionIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        NodoCancion nodo = biblioteca.getNodo(cancionIndex);
        if (nodo != null) {
            selectedPlaylist.agregarCancion(nodo.cancion);
        } else {
            System.out.println("Canción no válida.");
        }
    }

    private static void eliminarCancionDePlaylist() {
        if (playlists.getTamaño() == 0) {
            System.out.println("No hay playlists disponibles.");
            return;
        }

        System.out.println("Playlists disponibles:");
        playlists.mostrarPlaylists();

        System.out.print("Seleccione playlist: ");
        int playlistIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Playlist selectedPlaylist = playlists.obtenerPlaylist(playlistIndex);
        if (selectedPlaylist == null) {
            System.out.println("Playlist no válida.");
            return;
        }

        selectedPlaylist.mostrarCanciones();
        System.out.print("Seleccione canción a eliminar: ");
        int cancionIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        NodoCancion nodo = biblioteca.getNodo(cancionIndex);
        if (nodo != null) {
            selectedPlaylist.eliminarCancion(nodo.cancion.getTitulo());
        } else {
            System.out.println("Canción no válida.");
        }
    }

    private static void verPlaylists() {
        playlists.mostrarPlaylists();
    }

    private static void verCancionesDePlaylist() {
        if (playlists.getTamaño() == 0) {
            System.out.println("No hay playlists disponibles.");
            return;
        }

        System.out.println("Playlists disponibles:");
        playlists.mostrarPlaylists();

        System.out.print("Seleccione playlist: ");
        int playlistIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        Playlist selectedPlaylist = playlists.obtenerPlaylist(playlistIndex);
        if (selectedPlaylist != null) {
            selectedPlaylist.mostrarCanciones();
        } else {
            System.out.println("Playlist no válida.");
        }
    }
}