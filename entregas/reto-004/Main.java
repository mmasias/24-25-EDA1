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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
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
                    reproductor.anterior(); // Implementa lógica si es necesario
                    break;
                case 4:
                    reproductor.mostrarCola(); // Acceso correcto a mostrar cola
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

    private static void menuBiblioteca(Reproductor reproductor, Scanner scanner) {
        while (true) {
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
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para añadir canción a favoritos
                    break;
                case 2:
                    // Lógica para eliminar canción de favoritos
                    break;
                case 3:
                    // Lógica para ver canciones favoritas
                    break;
                case 4:
                    System.out.print("Nombre de la nueva playlist: ");
                    scanner.nextLine(); // Limpiar el buffer
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
                    // Lógica para eliminar canción de playlist
                    break;
                case 7:
                    reproductor.verPlaylists();
                    break;
                case 8:
                    // Lógica para ver canciones de una playlist
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
