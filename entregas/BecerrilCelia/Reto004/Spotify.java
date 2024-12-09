package Reto004;
import java.util.Scanner;

public class Spotify {

    private static ListaCircularCanciones cancionesDisponibles = new ListaCircularCanciones();
    private static ListaCircularCanciones cancionesFavoritas = new ListaCircularCanciones();
    private static ListaPlaylists playlists = new ListaPlaylists();
    private static ColaCanciones colaReproduccion = new ColaCanciones();
    private static PilaCanciones historialReproduccion = new PilaCanciones();
    private static Cancion cancionActual = null;
    private static boolean modoAleatorio = false;
    private static boolean modoRepeticion = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void inicializarCanciones() {
        cancionesDisponibles.agregarCancion(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        cancionesDisponibles.agregarCancion(new Cancion("Los Dinosaurios", "Charly García", 234));
        cancionesDisponibles.agregarCancion(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        cancionesDisponibles.agregarCancion(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        cancionesDisponibles.agregarCancion(new Cancion("No Soy Un Extraño", "Charly García", 295));
        cancionesDisponibles.agregarCancion(new Cancion("Seminare", "Serú Girán", 238));
        cancionesDisponibles.agregarCancion(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        cancionesDisponibles.agregarCancion(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        cancionesDisponibles.agregarCancion(new Cancion("Película sordomuda", "Charly García", 235));
        cancionesDisponibles.agregarCancion(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));

        // Poner la primera canción en reproducción por defecto
        cancionActual = cancionesDisponibles.obtenerCancionActual();
        System.out.println("Reproduciendo por defecto: " + cancionActual);

        // Encolar las siguientes 5 canciones
        cancionesDisponibles.encolarSiguientes(colaReproduccion, 5);
    }

    public static void mostrarBibliotecaInicial() {
        System.out.println("=== SPOTIFY  ===\n");
        System.out.println("BIBLIOTECA INICIAL\n");
        System.out.println("Canciones disponibles:\n");
        cancionesDisponibles.mostrarCanciones();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Reproducción");
        System.out.println("2. Biblioteca");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarMenuBiblioteca() {
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
    }

    public static void mostrarMenuReproduccion() {
        System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
        System.out.println("1. Ver canción actual");
        System.out.println("2. Reproducir siguiente");
        System.out.println("3. Reproducir anterior");
        System.out.println("4. Ver cola de reproducción");
        System.out.println("5. Ver historial de reproducción");
        System.out.println("6. Activar/desactivar modo aleatorio");
        System.out.println("7. Activar/desactivar repetición");
        System.out.println("8. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }
    public static void manejarOpcionBiblioteca(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Canciones disponibles:");
                cancionesDisponibles.mostrarCanciones();
                System.out.print("Seleccione canción a añadir a favoritos: ");
                int indexFavorito = scanner.nextInt();
                Cancion cancionFavorito = cancionesDisponibles.obtenerCancion(indexFavorito);
                if (cancionFavorito != null) {
                    cancionesFavoritas.agregarCancion(cancionFavorito);
                    System.out.println("Canción añadida a favoritos.");
                } else {
                    System.out.println("Canción no encontrada.");
                }
                break;
            case 2:
                System.out.println("Canciones favoritas:");
                cancionesFavoritas.mostrarCanciones();
                System.out.print("Seleccione canción a eliminar de favoritos: ");
                int indexEliminarFavorito = scanner.nextInt();
                Cancion cancionEliminarFavorito = cancionesFavoritas.obtenerCancion(indexEliminarFavorito);
                if (cancionEliminarFavorito != null) {
                    cancionesFavoritas.eliminar(cancionEliminarFavorito.getTitulo());
                    System.out.println("Canción eliminada de favoritos.");
                } else {
                    System.out.println("Canción no encontrada.");
                }
                break;
            case 3:
                System.out.println("Canciones favoritas:");
                cancionesFavoritas.mostrarCanciones();
                break;
            case 4:
                System.out.print("Ingrese el nombre de la nueva playlist: ");
                String nombrePlaylist = scanner.next();
                playlists.agregarPlaylist(new Playlist(nombrePlaylist));
                System.out.println("Playlist \"" + nombrePlaylist + "\" creada con éxito.");
                break;
            case 5:
                System.out.println("Playlists disponibles:");
                playlists.mostrarPlaylists();
                System.out.print("Seleccione playlist: ");
                int indexPlaylist = scanner.nextInt();
                Playlist playlistAgregar = playlists.obtenerPlaylist(indexPlaylist);
                if (playlistAgregar != null) {
                    System.out.println("Canciones disponibles:");
                    cancionesDisponibles.mostrarCanciones();
                    System.out.print("Seleccione canción a añadir: ");
                    int indexCancion = scanner.nextInt();
                    Cancion cancionAgregar = cancionesDisponibles.obtenerCancion(indexCancion);
                    if (cancionAgregar != null) {
                        playlistAgregar.agregarCancion(cancionAgregar);
                        System.out.println("\"" + cancionAgregar.getTitulo() + "\" añadida a " + playlistAgregar.getNombre());
                    } else {
                        System.out.println("Canción no encontrada.");
                    }
                } else {
                    System.out.println("Playlist no encontrada.");
                }
                break;
            case 6:
                System.out.println("Playlists disponibles:");
                playlists.mostrarPlaylists();
                System.out.print("Seleccione playlist: ");
                int indexPlaylistEliminar = scanner.nextInt();
                Playlist playlistEliminar = playlists.obtenerPlaylist(indexPlaylistEliminar);
                if (playlistEliminar != null) {
                    System.out.println("Canciones en la playlist:");
                    playlistEliminar.mostrarCanciones();
                    System.out.print("Seleccione canción a eliminar: ");
                    int indexCancionEliminar = scanner.nextInt();
                    Cancion cancionEliminar = playlistEliminar.obtenerCancion(indexCancionEliminar);
                    if (cancionEliminar != null) {
                        playlistEliminar.eliminarCancion(cancionEliminar.getTitulo());
                        System.out.println("\"" + cancionEliminar.getTitulo() + "\" eliminada de " + playlistEliminar.getNombre());
                    } else {
                        System.out.println("Canción no encontrada.");
                    }
                } else {
                    System.out.println("Playlist no encontrada.");
                }
                break;
            case 7:
                System.out.println("Playlists:");
                playlists.mostrarPlaylists();
                break;
            case 8:
                System.out.print("Ingrese el nombre de la playlist: ");
                String nombrePlaylistVer = scanner.next();
                Playlist playlistVer = playlists.buscarPlaylist(nombrePlaylistVer);
                if (playlistVer != null) {
                    System.out.println("Canciones en la playlist " + nombrePlaylistVer + ":");
                    playlistVer.mostrarCanciones();
                } else {
                    System.out.println("Playlist no encontrada.");
                }
                break;
            case 9:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void manejarOpcionReproduccion(int opcion) {
        switch (opcion) {
            case 1:
                if (cancionActual != null) {
                    System.out.println("Canción actual: " + cancionActual);
                } else {
                    System.out.println("No hay canción en reproducción.");
                }
                break;
            case 2:
                // Avanzar a la siguiente canción
                historialReproduccion.apilar(cancionActual);
                cancionesDisponibles.avanzar();
                cancionActual = cancionesDisponibles.obtenerCancionActual();
                System.out.println("Reproduciendo: " + cancionActual);
                break;
            case 3:
                if (!historialReproduccion.estaVacia()) {
                    cancionesDisponibles.retroceder();
                    cancionActual = historialReproduccion.desapilar();
                    System.out.println("Reproduciendo: " + cancionActual);
                } else {
                    System.out.println("No hay canciones en el historial de reproducción.");
                }
                break;
            case 4:
                System.out.println("Cola de reproducción:");
                colaReproduccion.mostrarCola();
                break;
            case 5:
                System.out.println("Historial de reproducción:");
                historialReproduccion.mostrarPila();
                break;
            case 6:
                modoAleatorio = !modoAleatorio;
                System.out.println("Modo aleatorio " + (modoAleatorio ? "activado" : "desactivado") + ".");
                break;
            case 7:
                modoRepeticion = !modoRepeticion;
                System.out.println("Modo repetición " + (modoRepeticion ? "activado" : "desactivado") + ".");
                break;
            case 8:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                int opcionReproduccion = 0;
                while (opcionReproduccion != 8) {
                    mostrarMenuReproduccion();
                    opcionReproduccion = scanner.nextInt();
                    manejarOpcionReproduccion(opcionReproduccion);
                }
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
        inicializarCanciones();
        mostrarBibliotecaInicial();

        int opcion = 0;
        while (opcion != 3) {
            mostrarMenu();
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        }

        scanner.close();
    }
}
