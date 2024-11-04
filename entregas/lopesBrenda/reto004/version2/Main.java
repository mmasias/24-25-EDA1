package entregas.lopesBrenda.reto004.version2;

import java.util.Scanner;

public class Main {
    public static Cancion[] cancionesDisponibles = {
        new Cancion("Demoliendo Hoteles", "Charly García", 258),
        new Cancion("Los Dinosaurios", "Charly García", 234),
        new Cancion("Rasguña Las Piedras", "Sui Generis", 285),
        new Cancion("Canción Para Mi Muerte", "Sui Generis", 342),
        new Cancion("No Soy Un Extraño", "Charly García", 295),
        new Cancion("Seminare", "Serú Girán", 238),
        new Cancion("Promesas Sobre El Bidet", "Charly García", 243),
        new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266),
        new Cancion("Película sordomuda", "Charly García", 235),
        new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325),
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reproductor reproductor = new Reproductor();
        
        while (true) {
            System.out.println("=== SPOTIFY ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuReproduccion(reproductor);
                    break;
                case 2:
                    menuBiblioteca(reproductor, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuReproduccion(Reproductor reproductor) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n"+"=== MENÚ REPRODUCCIÓN ===");
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

                switch (opcion) {
                    case 1:
                        if (reproductor.cancionActual == null) {
                            System.out.print("No hay canción en reproducción. ¿Desea comenzar a reproducir? (S/N): ");
                            char respuesta = scanner.next().charAt(0);
                            if (respuesta == 'S' || respuesta == 's') {
                                System.out.print("Seleccione canción (1-" + cancionesDisponibles.length + "): ");
                                int cancionIndex = scanner.nextInt() - 1;
                                if (cancionIndex >= 0 && cancionIndex < cancionesDisponibles.length) {
                                    reproductor.agregarCancionACola(cancionesDisponibles[cancionIndex]);
                                    reproductor.reproducir();
                                } else {
                                    System.out.println("Índice de canción no válido.");
                                }
                            }
                        } else {
                            System.out.println("Canción actual: " + reproductor.cancionActual);
                        }
                        break;
                    case 2:
                        reproductor.siguiente();
                        break;
                    case 3:
                        reproductor.anterior();
                        break;
                    case 4:
                        reproductor.mostrarCola();
                        break;
                    case 5:
                        reproductor.mostrarHistorial();
                        break;
                    case 6:
                        reproductor.activarModoAleatorio();
                        break;
                    case 7:
                        reproductor.activarModoRepetir();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void menuBiblioteca(Reproductor reproductor, Scanner scanner) {
        while (true) {
            System.out.println("\n"+"=== MENÚ BIBLIOTECA ===");
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

            switch (opcion) {
                case 1:
                    reproductor.mostrarCancionesDisponibles();
                    System.out.print("Seleccione la canción a añadir a favoritos: ");
                    int favoritaIndex = scanner.nextInt() - 1;
                    if (favoritaIndex >= 0 && favoritaIndex < cancionesDisponibles.length) {
                        reproductor.añadirCancionAFavoritos(cancionesDisponibles[favoritaIndex]);
                    } else {
                        System.out.println("Índice de canción no válido.");
                    }
                    break;
                case 2:
                    reproductor.verCancionesFavoritas();
                    System.out.print("Seleccione la canción a eliminar de favoritos: ");
                    int eliminarFavoritaIndex = scanner.nextInt() - 1;
                    if (eliminarFavoritaIndex >= 0 && eliminarFavoritaIndex < reproductor.numFavoritas) {
                        reproductor.eliminarCancionDeFavoritos(reproductor.cancionesFavoritas[eliminarFavoritaIndex]);
                    } else {
                        System.out.println("Índice de canción no válido.");
                    }
                    break;
                case 3:
                    reproductor.verCancionesFavoritas();
                    break;
                case 4:
                    System.out.print("Nombre de la nueva playlist: ");
                    scanner.nextLine();
                    String nombrePlaylist = scanner.nextLine();
                    reproductor.crearPlaylist(nombrePlaylist);
                    break;
                case 5:
                    reproductor.verPlaylists();
                    System.out.print("Seleccione playlist: ");
                    int playlistIndex = scanner.nextInt() - 1;
                    reproductor.mostrarCancionesDisponibles();
                    System.out.print("Seleccione canción a añadir: ");
                    int cancionIndex = scanner.nextInt() - 1;
                    reproductor.añadirCancionAPlaylist(playlistIndex, cancionesDisponibles[cancionIndex]);
                    break;
                case 6:
                    reproductor.verPlaylists();
                    System.out.print("Seleccione playlist: ");
                    int eliminarPlaylistIndex = scanner.nextInt() - 1;
                    if (eliminarPlaylistIndex >= 0 && eliminarPlaylistIndex < reproductor.numPlaylists) {
                        reproductor.playlists[eliminarPlaylistIndex].mostrarCanciones();
                        System.out.print("Seleccione canción a eliminar: ");
                        int cancionEliminarIndex = scanner.nextInt() - 1;
                        if (cancionEliminarIndex >= 0 && cancionEliminarIndex < Main.cancionesDisponibles.length) {
                            reproductor.playlists[eliminarPlaylistIndex].eliminarCancion(Main.cancionesDisponibles[cancionEliminarIndex]);
                            System.out.println("Canción eliminada de la playlist.");
                        } else {
                            System.out.println("Índice de canción no válido.");
                        }
                    } else {
                        System.out.println("Índice de playlist no válido.");
                    }
                    break;
                case 7:
                    reproductor.verPlaylists();
                    break;
                case 8:
                    System.out.print("Seleccione playlist: ");
                    int verPlaylistIndex = scanner.nextInt() - 1;
                    if (verPlaylistIndex >= 0 && verPlaylistIndex < reproductor.numPlaylists) {
                        reproductor.playlists[verPlaylistIndex].mostrarCanciones();
                    } else {
                        System.out.println("Índice de playlist no válido.");
                    }
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
