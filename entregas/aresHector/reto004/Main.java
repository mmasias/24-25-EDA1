import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReproductorMusica reproductor = new ReproductorMusica();
        BibliotecaMusical biblioteca = new BibliotecaMusical();

        // Ejemplo de canciones disponibles (puedes añadir más)
        Cancion cancion1 = new Cancion("Tusa", "Karol G & Nicki Minaj", 204);
        Cancion cancion2 = new Cancion("Hawái", "Maluma", 183);
        Cancion cancion3 = new Cancion("Dákiti", "Bad Bunny & Jhay Cortez", 207);

        // Agregar canciones a la biblioteca
        biblioteca.agregarCancionAFavoritos(cancion1);  // Ejemplo de favorito
        reproductor.agregarCancionCola(cancion2);       // Agregar a cola de reproducción
        reproductor.agregarCancionCola(cancion3);

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    menuReproduccion(reproductor, scanner);
                    break;
                case 2:
                    menuBiblioteca(biblioteca, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void menuReproduccion(ReproductorMusica reproductor, Scanner scanner) {
        boolean reproduccionActiva = true;
        
        while (reproduccionActiva) {
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
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.println("Reproduciendo: " + reproductor.cancionActual);
                    break;
                case 2:
                    reproductor.reproducirSiguiente();
                    break;
                case 3:
                    reproductor.reproducirAnterior();
                    break;
                case 4:
                    reproductor.verColaReproduccion();
                    break;
                case 5:
                    reproductor.verHistorialReproduccion();
                    break;
                case 6:
                    reproductor.activarDesactivarAleatorio();
                    break;
                case 7:
                    reproductor.activarDesactivarRepeticion();
                    break;
                case 8:
                    reproduccionActiva = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void menuBiblioteca(BibliotecaMusical biblioteca, Scanner scanner) {
        boolean enBiblioteca = true;
        
        while (enBiblioteca) {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Crear nueva playlist");
            System.out.println("5. Ver playlists");
            System.out.println("6. Ver canciones de una playlist");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la canción para añadir a favoritos: ");
                    String tituloFavorito = scanner.nextLine();
                    Cancion cancionParaFavoritos = buscarCancion(tituloFavorito, biblioteca);
                    if (cancionParaFavoritos != null) {
                        biblioteca.agregarCancionAFavoritos(cancionParaFavoritos);
                    } else {
                        System.out.println("Canción no encontrada en la biblioteca.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el título de la canción para eliminar de favoritos: ");
                    String tituloEliminarFavorito = scanner.nextLine();
                    Cancion cancionEliminarFavoritos = buscarCancion(tituloEliminarFavorito, biblioteca);
                    if (cancionEliminarFavoritos != null) {
                        biblioteca.eliminarCancionDeFavoritos(cancionEliminarFavoritos);
                    } else {
                        System.out.println("Canción no encontrada en favoritos.");
                    }
                    break;
                case 3:
                    biblioteca.verCancionesFavoritas();
                    break;
                case 4:
                    System.out.print("Nombre de la nueva playlist: ");
                    String nombrePlaylist = scanner.nextLine();
                    biblioteca.crearPlaylist(nombrePlaylist);
                    break;
                case 5:
                    biblioteca.verPlaylists();
                    break;
                case 6:
                    System.out.print("Ingrese el nombre de la playlist: ");
                    String playlistSeleccionada = scanner.nextLine();
                    biblioteca.verCancionesPlaylist(playlistSeleccionada);
                    break;
                case 7:
                    enBiblioteca = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Método auxiliar para buscar canciones en la biblioteca por título
    public static Cancion buscarCancion(String titulo, BibliotecaMusical biblioteca) {
        for (Cancion cancion : biblioteca.getTodasLasCanciones()) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;
    }
}
