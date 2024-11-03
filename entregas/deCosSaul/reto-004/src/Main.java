import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();

        Cancion cancion = new Cancion("Papercut", "Linkin Park", 300);
        Cancion cancion2 = new Cancion("One Step Closer", "Linkin Park", 300);
        Cancion cancion3 = new Cancion("With You", "Linkin Park", 300);
        Cancion cancion4 = new Cancion("Points of Authority", "Linkin Park", 300);
        biblioteca.crearPlaylist("Hybrid Theory");
        biblioteca.anadirCancionAPlaylist(0, cancion);
        biblioteca.anadirCancionAPlaylist(0, cancion2);
        biblioteca.anadirCancionAPlaylist(0, cancion3);
        biblioteca.anadirCancionAPlaylist(0, cancion4);
        biblioteca.verPlaylists();

        int opcionPrincipal;
        limpiarPantalla();

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();
            limpiarPantalla();

            switch (opcionPrincipal) {
                case 1:
                    limpiarPantalla();
                    int opcionReproduccion;
                    do {
                        System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
                        System.out.println("1. Seleccionar playlist");
                        System.out.println("2. Ver canción actual");
                        System.out.println("3. Reproducir siguiente");
                        System.out.println("4. Reproducir anterior");
                        System.out.println("5. Ver cola de reproducción");
                        System.out.println("6. Ver historial");
                        System.out.println("7. Activar/desactivar aleatorio");
                        System.out.println("8. Activar/desactivar repetición");
                        System.out.println("9. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionReproduccion = scanner.nextInt();
                        limpiarPantalla();
                        scanner.nextLine();

                        switch (opcionReproduccion) {
                            case 1:

                                biblioteca.verPlaylists();

                                System.out.print("Introduzca el índice de la playlist: ");
                                int indicePlaylistSeleccionada = scanner.nextInt();
                                limpiarPantalla();
                                scanner.nextLine();

                                String resultado = biblioteca.verCancionesDePlaylist(indicePlaylistSeleccionada);

                                if (!resultado.equals("Índice de playlist inválido.")) {
                                    reproductor.seleccionarPlaylist(biblioteca.seleccionarPlaylistParaReproduccion(indicePlaylistSeleccionada));
                                } else {
                                    System.out.println(resultado);
                                }

                                pausaYLimpia();
                                break;
                            case 2:
                                reproductor.reproducirCancionActual();
                                pausaYLimpia();
                                break;
                            case 3:
                                reproductor.siguienteCancion();
                                pausaYLimpia();
                                break;
                            case 4:
                                reproductor.cancionAnterior();
                                pausaYLimpia();
                                break;
                            case 5:
                                reproductor.verColaDeReproduccion();
                                pausaYLimpia();
                                break;
                            case 6:
                                reproductor.mostrarHistorial();
                                pausaYLimpia();
                                break;
                            case 7:
                                reproductor.activarModoAleatorio();
                                scanner.nextLine();
                                limpiarPantalla();
                                break;
                            case 8:
                                reproductor.activarModoRepeticion();
                                pausaYLimpia();
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } while (opcionReproduccion != 9);
                    break;

                case 2:
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
                        limpiarPantalla();
                        scanner.nextLine();

                        switch (opcionBiblioteca) {
                            case 1:
                                biblioteca.verPlaylists();
                                System.out.println();
                                System.out.print("Introduzca el indice de la playlist: ");
                                int seleccion = scanner.nextInt();
                                Playlist playlistSeleccionada = biblioteca.obtenerPlaylist(seleccion);

                                limpiarPantalla();

                                System.out.println("=== Canciones ===");
                                playlistSeleccionada.getCanciones().mostrar();
                                System.out.println();

                                System.out.print("Introduce el indice de la cancion:");
                                seleccion = scanner.nextInt();
                                Cancion cancionSeleccionada = playlistSeleccionada.getCancionByIndex(seleccion);
                                biblioteca.anadirAFavoritos(cancionSeleccionada);

                                pausaYLimpia();

                                break;
                            case 2:
                                biblioteca.verCancionesFavoritas();
                                System.out.print("Introduce el indice de la cancion:");
                                seleccion = scanner.nextInt();
                                biblioteca.eliminarDeFavoritos(seleccion-1);
                                pausaYLimpia();
                                break;
                            case 3:
                                System.out.println("Canciones favoritas:");
                                biblioteca.verCancionesFavoritas();
                                pausaYLimpia();
                                break;
                            case 4:
                                System.out.print("Introduzca el título de la nueva playlist: ");
                                String nuevoTituloPlaylist = scanner.nextLine();
                                biblioteca.crearPlaylist(nuevoTituloPlaylist);
                                pausaYLimpia();
                                break;
                            case 5:
                                biblioteca.verPlaylists();
                                System.out.println();
                                System.out.print("Introduzca el indice de la playlist: ");
                                int playlist = scanner.nextInt();
                                scanner.nextLine();
                                limpiarPantalla();

                                System.out.print("Introduce el titulo de la cancion: ");
                                String titulo = scanner.nextLine();

                                System.out.print("Introduce el autor de la cancion: ");
                                String autor = scanner.nextLine();

                                System.out.print("Introduce la duracion: ");
                                int duracion = scanner.nextInt();

                                biblioteca.crearCancionYAnadir(playlist, titulo, autor, duracion);

                                limpiarPantalla();
                                break;

                                
                            case 6:
                                biblioteca.verPlaylists();
                                System.out.println();
                                System.out.print("Introduzca el indice de la playlist: ");
                                playlist = scanner.nextInt();
                                scanner.nextLine();
                                limpiarPantalla();
                                
                                biblioteca.obtenerPlaylist(playlist).getCanciones().mostrar();
                                System.out.println();
                                System.out.print("Introduzca el indice de la cancion: ");
                                int cancionEliminar = scanner.nextInt();

                                biblioteca.eliminarCancionDePlaylist(playlist, cancionEliminar);


                                break;
                            case 7:
                                System.out.println("Playlists disponibles:");
                                biblioteca.verPlaylists();
                                pausaYLimpia();
                                break;
                            case 8:
                                biblioteca.verPlaylists();
                                System.out.println();

                                System.out.print("Introduzca el índice de la playlist: ");
                                int indicePlaylistVer = scanner.nextInt();
                                limpiarPantalla();
                                System.out.println(biblioteca.verCancionesDePlaylist(indicePlaylistVer));
                                pausaYLimpia();
                            break;
                            case 9:
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } while (opcionBiblioteca != 9);
                    break;

                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 3);


    }
    static void pausaYLimpia(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        limpiarPantalla();
    }
    static void limpiarPantalla(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}
