package Ejercicio001.Reto004;

import java.util.Scanner;

public class Main {
    Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        biblioteca.mostrarCancionesDisponibles();


        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Ver canción actual");
                    System.out.println("2. Reproducir siguiente");
                    System.out.println("3. Reproducir anterior");
                    System.out.println("4. Ver cola de reproducción");
                    System.out.println("5. Ver historial de reproducción");
                    System.out.println("6. Activar/desactivar modo aleatorio");
                    System.out.println("7. Activar/desactivar repetición");
                    System.out.println("8. Añadir canción a la cola de reproducción");
                    System.out.println("9. Añadir canción a favoritos");
                    System.out.println("10. Eliminar canción de la cola de reproducción");
                    System.out.println("11. Agregar cancion en reproduccion a una nueva playlist");
                    System.out.println("12. Añadir cancion en reporduccion a una playlist existente");
                    System.out.println("Ingrese una opción:");
                    int opcionReproduccion = scanner.nextInt();
                    switch (opcionReproduccion) {
                        case 1:
                            reproductor.reproducirCancion();

                        case 2:
                            reproductor.siguienteCancion();

                        case 3:
                            reproductor.cancionAnterior();

                        case 4:
                            reproductor.verCola();

                        case 5:
                            reproductor.verHistorial();

                        case 6:
                            reproductor.activarModoAleatorio(!reproductor.modoAleatorio);

                        case 7:
                            reproductor.activarModoRepetir(!reproductor.modoRepeticion);

                        case 8:
                            System.out.println("CATÁLOGO DE CANCIONES");
                            biblioteca.verAlbums();
                            System.out.println("Ingrese el título de la canción:");
                            String titulo = scanner.next();
                            System.out.println("Ingrese el artista de la canción:");
                            String artista = scanner.next();
                            System.out.println("Ingrese la duración de la canción:");
                            int duracion = scanner.nextInt();
                            Cancion cancion = new Cancion(titulo, artista, duracion);
                            reproductor.agregarCancionCola(cancion);

                        case 9:
                            System.out.println("CATÁLOGO DE CANCIONES");
                            biblioteca.verAlbums();
                            System.out.println("Ingrese el título de la canción o ingrese 1 si quiere añadir la que se esta reproduciendo actualmente:");
                            String tituloFavorita = scanner.next();
                            if (tituloFavorita.equals("1")) {
                                Cancion cancionActual = reproductor.getCancionActual();
                                if (cancionActual != null) {
                                    cancionActual.marcarComoFavorito(false);
                                    biblioteca.añadirCancionFavorita(cancionActual);
                                } else {
                                    System.out.println("No hay canciones en reproducción.");
                                }
                            } else {
                                System.out.println("Ingrese el artista de la canción:");
                                String artistaFavorita = scanner.next();
                                System.out.println("Ingrese la duración de la canción:");
                                int duracionFavorita = scanner.nextInt();
                                Cancion cancionFavorita = new Cancion(tituloFavorita, artistaFavorita, duracionFavorita);
                                cancionFavorita.marcarComoFavorito(true);
                                biblioteca.añadirCancionFavorita(cancionFavorita);
                            }

                        case 10:
                            reproductor.verCola();
                            System.out.println("Ingrese el título de la canción a eliminar:");
                            String tituloEliminar = scanner.next();
                            Cancion cancionEliminar = biblioteca.buscarCancion(tituloEliminar, reproductor.cola);
                            if (cancionEliminar != null) {
                                reproductor.eliminarCancionCola(cancionEliminar);
                            } else {
                                System.out.println("Canción no encontrada.");
                            }
                        case 11:
                            System.out.println("Ingrese el nombre de la playlist:");
                            String nombrePlaylist = scanner.next();
                            Playlist playlist = new Playlist(nombrePlaylist);
                            playlist.añadirCancion(reproductor.getCancionActual());
                            biblioteca.crearPlaylist(playlist);
                        case 12:
                            System.out.println("PLAYLISTS");
                            biblioteca.verPlaylist();
                            System.out.println("Ingrese el nombre de la playlist:");
                            String nombrePlaylistExistente = scanner.next();
                            Playlist playlistExistente = biblioteca.buscaPlaylist(nombrePlaylistExistente);
                            if (playlistExistente != null) {
                                playlistExistente.añadirCancion(reproductor.getCancionActual());
                            } else {
                                System.out.println("Playlist no encontrada.");
                            }

                    }
                    break;
                case 2:
                    System.out.println("1. Ver álbumes predeterminados");
                    System.out.println("2. Ver canciones favoritas");
                    System.out.println("3. Ver playlist");
                    System.out.println("Ingrese una opción:");
                    int opcionBiblioteca = scanner.nextInt();
                    switch (opcionBiblioteca) {
                        case 1:
                            biblioteca.verAlbums();
                        case 2:
                            biblioteca.verCancionesFavoritas();
                            System.out.println("1. Añadir cancion favorita a cola de reproducción");
                            System.out.println("2. Eliminar canción favorita");
                            System.out.println("Ingrese una opción:");
                            int opcionFavoritas = scanner.nextInt();
                            switch (opcionFavoritas) {
                                case 1:
                                    System.out.println("Canciones favoritas:");
                                    biblioteca.verCancionesFavoritas();
                                    System.out.println("Ingrese el título de la canción a añadir:");
                                    String tituloFavorita = scanner.next();
                                    Cancion cancionFavorita = biblioteca.buscarCancion(tituloFavorita, biblioteca.cancionesFavoritas);
                                    if (cancionFavorita != null) {
                                        reproductor.agregarCancionCola(cancionFavorita);
                                    } else {
                                        System.out.println("Canción no encontrada.");
                                    }
                                case 2:
                                    System.out.println("Canciones favoritas:");
                                    biblioteca.verCancionesFavoritas();
                                    System.out.println("Ingrese el título de la canción a eliminar:");
                                    String tituloEliminar = scanner.next();
                                    Cancion cancionEliminar = biblioteca.buscarCancion(tituloEliminar, biblioteca.cancionesFavoritas);
                                    if (cancionEliminar != null) {
                                        cancionEliminar.marcarComoFavorito(false);
                                        biblioteca.eliminarCancionDeFavoritos(cancionEliminar);
                                    } else {
                                        System.out.println("Canción no encontrada.");
                                    }


                            }
                        case 3:
                            System.out.println("1. Reproducir playlist");
                            System.out.println("2. Eliminar playlist");
                            System.out.println("3. Agregar cancion a playlist");
                            System.out.println("4. Eliminar cancion de playlist");
                            System.out.println("5. Ver canciones de playlist");
                            System.out.println("Ingrese una opción:");
                            int opcionPlaylist = scanner.nextInt();
                            switch (opcionPlaylist) {

                                case 1:
                                    System.out.println("PLAYLISTS");
                                    biblioteca.verPlaylist();
                                    System.out.println("Ingrese el nombre de la playlist a reproducir:");
                                    String nombrePlaylist = scanner.next();
                                    Playlist playlist = biblioteca.buscaPlaylist(nombrePlaylist);
                                    if (playlist != null) {
                                        reproductor.reproducirPlaylist(playlist);
                                    } else {
                                        System.out.println("Playlist no encontrada.");
                                    }
                                case 2:
                                    System.out.println("PLAYLISTS");
                                    biblioteca.verPlaylist();
                                    System.out.println("Ingrese el nombre de la playlist a eliminar:");
                                    String nombrePlaylistEliminar = scanner.next();
                                    Playlist playlistEliminar = biblioteca.buscaPlaylist(nombrePlaylistEliminar);
                                    if (playlistEliminar != null) {
                                        biblioteca.borraPlaylist(nombrePlaylistEliminar);
                                    } else {
                                        System.out.println("Playlist no encontrada.");
                                    }
                                case 3:
                                    System.out.println("PLAYLISTS");
                                    biblioteca.verPlaylist();
                                    System.out.println("Ingrese el nombre de la playlist:");
                                    String nombrePlaylistExistente = scanner.next();
                                    Playlist playlistExistente = biblioteca.buscaPlaylist(nombrePlaylistExistente);
                                    if (playlistExistente != null) {
                                        System.out.println("CATÁLOGO DE CANCIONES");
                                        biblioteca.verAlbums();
                                        System.out.println("Ingrese el título de la canción:");
                                        String titulo = scanner.next();
                                        System.out.println("Ingrese el artista de la canción:");
                                        String artista = scanner.next();
                                        System.out.println("Ingrese la duración de la canción:");
                                        int duracion = scanner.nextInt();
                                        Cancion cancion = new Cancion(titulo, artista, duracion);
                                        playlistExistente.añadirCancion(cancion);
                                    } else {
                                        System.out.println("Playlist no encontrada.");
                                    }
                                case 4:
                                    System.out.println("PLAYLISTS");
                                    biblioteca.verPlaylist();
                                    System.out.println("Ingrese el nombre de la playlist:");
                                    String nombrePlaylistusar = scanner.next();
                                    Playlist playlistuso = biblioteca.buscaPlaylist(nombrePlaylistusar);
                                    if (playlistuso != null) {
                                        playlistuso.mostrarCanciones();
                                        System.out.println("Ingrese el título de la canción a eliminar:");
                                        String tituloEliminar = scanner.next();
                                        Cancion cancionEliminar = biblioteca.buscarCancion(tituloEliminar, playlistuso.getCanciones());
                                        if (cancionEliminar != null) {
                                            playlistuso.eliminarCancion(cancionEliminar);
                                        } else {
                                            System.out.println("Canción no encontrada.");
                                        }
                                    } else {
                                        System.out.println("Playlist no encontrada.");
                                    }
                                case 5:
                                    System.out.println("PLAYLISTS");
                                    biblioteca.verPlaylist();
                                    System.out.println("Ingrese el nombre de la playlist:");
                                    String nombrePlaylistver = scanner.next();
                                    Playlist playlistver = biblioteca.buscaPlaylist(nombrePlaylistver);
                                    if (playlistver != null) {
                                        playlistver.mostrarCanciones();
                                    } else {
                                        System.out.println("Playlist no encontrada.");
                                    }

                            }


                    }
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }
}