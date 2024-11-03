package entregas.naranjoDylan.reto004;

import java.util.Scanner;

public class Sistemamusica {
    private static Biblioteca biblioteca;
    private static Reproductor reproductor;
    private static Lista favoritas;
    private static Lista playlists;
    private static Scanner scanner;

    public static void main(String[] args) {
        inicializar();
        menuPrincipal();
    }

    private static void inicializar() {
        biblioteca = new Biblioteca();
        biblioteca.inicializar();
        reproductor = new Reproductor();
        favoritas = new Lista();
        playlists = new Lista();
        scanner = new Scanner(System.in);
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema de música. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void menuReproduccion() {
        while (true) {
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
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verCancionActual();
                    break;
                case 2:
                    reproductor.reproducirSiguiente(biblioteca.getCanciones());
                    break;
                case 3:
                    reproductor.reproducirAnterior();
                    break;
                case 4:
                    verColaReproduccion();
                    break;
                case 5:
                    verHistorial();
                    break;
                case 6:
                    reproductor.setModoAleatorio(!reproductor.isModoAleatorio());
                    System.out
                            .println("Modo aleatorio: " + (reproductor.isModoAleatorio() ? "Activado" : "Desactivado"));
                    break;
                case 7:
                    reproductor.setModoRepeticion(!reproductor.isModoRepeticion());
                    System.out.println(
                            "Modo repetición: " + (reproductor.isModoRepeticion() ? "Activado" : "Desactivado"));
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void menuBiblioteca() {
        while (true) {
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
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anadirAFavoritos();
                    break;
                case 2:
                    eliminarDeFavoritos();
                    break;
                case 3:
                    verFavoritas();
                    break;
                case 4:
                    crearPlaylist();
                    break;
                case 5:
                    anadirCancionAPlaylist();
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
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void verCancionActual() {
        Nodo cancionActual = reproductor.getCancionActual();
        if (cancionActual == null) {
            System.out.println("No hay canción en reproducción.");
            System.out.print("¿Desea comenzar a reproducir? (S/N): ");
            if (scanner.nextLine().equalsIgnoreCase("S")) {
                reproductor.reproducirSiguiente(biblioteca.getCanciones());
            }
        } else {
            System.out.println("▶ Reproduciendo: " + cancionActual.dato);
        }
    }

    private static void verColaReproduccion() {
        System.out.println("\nCOLA DE REPRODUCCIÓN:");
        Nodo cancionActual = reproductor.getCancionActual();
        if (cancionActual != null) {
            System.out.println("1. ▶ " + cancionActual.dato + " (ACTUAL)");
        }
        reproductor.getColaReproduccion().mostrar();
        System.out.println("\nEstado: " + (reproductor.isModoAleatorio() ? "Aleatorio" : "Normal") +
                " | Repetición: " + (reproductor.isModoRepeticion() ? "ON" : "OFF") +
                " | Aleatorio: " + (reproductor.isModoAleatorio() ? "ON" : "OFF"));
    }

    private static void verHistorial() {
        System.out.println("\nHISTORIAL DE REPRODUCCIÓN:");
        reproductor.getHistorial().mostrar();
    }

    private static void anadirAFavoritos() {
        System.out.println("\nCANCIONES DISPONIBLES:");
        biblioteca.getCanciones().mostrar();
        System.out.print("Seleccione el número de la canción para añadir a favoritos: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();
        Nodo nodoSeleccionado = obtenerNodo(biblioteca.getCanciones().cabeza, seleccion - 1);
        if (nodoSeleccionado != null) {
            favoritas.agregar(nodoSeleccionado.dato);
            System.out.println(((Cancion) nodoSeleccionado.dato).titulo + " añadida a favoritos.");
        } else {
            System.out.println("Selección no válida.");
        }
    }

    private static void eliminarDeFavoritos() {
        System.out.println("\nCANCIONES FAVORITAS:");
        favoritas.mostrar();
        System.out.print("Seleccione el número de la canción para eliminar de favoritos: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();
        Nodo nodoSeleccionado = obtenerNodo(favoritas.cabeza, seleccion - 1);
        if (nodoSeleccionado != null) {
            favoritas.eliminar(nodoSeleccionado.dato);
            System.out.println(((Cancion) nodoSeleccionado.dato).titulo + " eliminada de favoritos.");
        } else {
            System.out.println("Selección no válida.");
        }
    }

    private static void verFavoritas() {
        System.out.println("\nCANCIONES FAVORITAS:");
        favoritas.mostrar();
    }

    private static void crearPlaylist() {
        System.out.print("Nombre de la nueva playlist: ");
        String nombre = scanner.nextLine();
        Playlist nuevaPlaylist = new Playlist(nombre);
        playlists.agregar(nuevaPlaylist);
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    private static void anadirCancionAPlaylist() {
        System.out.println("\nPLAYLISTS DISPONIBLES:");
        mostrarPlaylists();
        System.out.print("Seleccione playlist: ");
        int seleccionPlaylist = scanner.nextInt();
        scanner.nextLine();
        Playlist playlistSeleccionada = (Playlist) obtenerNodo(playlists.cabeza, seleccionPlaylist - 1).dato;

        if (playlistSeleccionada != null) {
            System.out.println("\nCANCIONES DISPONIBLES:");
            biblioteca.getCanciones().mostrar();
            System.out.print("Seleccione canción a añadir: ");
            int seleccionCancion = scanner.nextInt();
            scanner.nextLine();
            Nodo cancionSeleccionada = obtenerNodo(biblioteca.getCanciones().cabeza, seleccionCancion - 1);

            if (cancionSeleccionada != null) {
                playlistSeleccionada.canciones.agregar(cancionSeleccionada.dato);
                System.out.println("\"" + ((Cancion) cancionSeleccionada.dato).titulo + "\" añadida a "
                        + playlistSeleccionada.nombre);
            } else {
                System.out.println("Selección de canción no válida.");
            }
        } else {
            System.out.println("Selección de playlist no válida.");
        }
    }

    private static void eliminarCancionDePlaylist() {
        System.out.println("\nPLAYLISTS DISPONIBLES:");
        mostrarPlaylists();
        System.out.print("Seleccione playlist: ");
        int seleccionPlaylist = scanner.nextInt();
        scanner.nextLine();
        Playlist playlistSeleccionada = (Playlist) obtenerNodo(playlists.cabeza, seleccionPlaylist - 1).dato;

        if (playlistSeleccionada != null) {
            System.out.println("\nCANCIONES EN LA PLAYLIST:");
            playlistSeleccionada.canciones.mostrar();
            System.out.print("Seleccione canción a eliminar: ");
            int seleccionCancion = scanner.nextInt();
            scanner.nextLine();
            Nodo cancionSeleccionada = obtenerNodo(playlistSeleccionada.canciones.cabeza, seleccionCancion - 1);

            if (cancionSeleccionada != null) {
                playlistSeleccionada.canciones.eliminar(cancionSeleccionada.dato);
                System.out.println("\"" + ((Cancion) cancionSeleccionada.dato).titulo + "\" eliminada de "
                        + playlistSeleccionada.nombre);
            } else {
                System.out.println("Selección de canción no válida.");
            }
        } else {
            System.out.println("Selección de playlist no válida.");
        }
    }

    private static void verPlaylists() {
        System.out.println("\nPLAYLISTS:");
        mostrarPlaylists();
    }

    private static void verCancionesDePlaylist() {
        if (playlists.cabeza == null) {
            System.out.println("No hay playlists disponibles.");
            return;
        }

        System.out.println("\nPLAYLISTS DISPONIBLES:");
        mostrarPlaylists();
        System.out.print("Seleccione playlist: ");
        int seleccionPlaylist = scanner.nextInt();
        scanner.nextLine();

        Nodo nodoPlaylist = obtenerNodo(playlists.cabeza, seleccionPlaylist - 1);
        if (nodoPlaylist == null) {
            System.out.println("Selección de playlist no válida.");
            return;
        }

        Playlist playlistSeleccionada = (Playlist) nodoPlaylist.dato;
        System.out.println("\nCANCIONES EN " + playlistSeleccionada.nombre + ":");
        if (playlistSeleccionada.canciones.cabeza == null) {
            System.out.println("Esta playlist está vacía.");
        } else {
            playlistSeleccionada.canciones.mostrar();
        }
    }

    private static void mostrarPlaylists() {
        Nodo actual = playlists.cabeza;
        int i = 1;
        while (actual != null) {
            Playlist playlist = (Playlist) actual.dato;
            System.out.println(i + ". " + playlist.nombre);
            actual = actual.siguiente;
            i++;
        }
    }

    private static Nodo obtenerNodo(Nodo cabeza, int indice) {
        if (indice < 0) {
            return null;
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice && actual != null; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }
}