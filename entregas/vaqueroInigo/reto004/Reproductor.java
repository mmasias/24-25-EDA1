package entregas.vaqueroInigo.reto004;

import java.util.Scanner;

public class Reproductor {
    private Biblioteca biblioteca;
    private Cola cola;
    private Historial historial;
    private boolean aleatorio;
    private boolean repetir;
    private Cancion cancionActual;

    public Reproductor(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.cola = new Cola();
        this.historial = new Historial();
        this.aleatorio = false;
        this.repetir = false;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        cargarCola();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuReproduccion(scanner);
                    break;
                case 2:
                    menuBiblioteca(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
        scanner.close();
    }

    private void cargarCola() {
        for (Cancion cancion : biblioteca.getCanciones()) {
            cola.agregar(cancion);
        }
    }

    private void menuReproduccion(Scanner scanner) {
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
                    verCancionActual();
                    break;
                case 2:
                    reproducirSiguiente();
                    break;
                case 3:
                    reproducirAnterior();
                    break;
                case 4:
                    verColaReproduccion();
                    break;
                case 5:
                    historial.mostrarHistorial();
                    break;
                case 6:
                    aleatorio = !aleatorio;
                    System.out.println("Modo aleatorio " + (aleatorio ? "activado" : "desactivado"));
                    break;
                case 7:
                    repetir = !repetir;
                    System.out.println("Repetición " + (repetir ? "activada" : "desactivada"));
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }

    private void verCancionActual() {
        if (cancionActual != null) {
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay canción en reproducción.");
            System.out.print("¿Desea comenzar a reproducir? (S/N): ");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.next().toUpperCase();
            if (respuesta.equals("S")) {
                reproducirSiguiente();
            }
        }
    }

    private void reproducirSiguiente() {
        if (repetir && cancionActual != null) {
            cola.agregar(cancionActual);
        }
        
        if (!cola.isEmpty()) {
            cancionActual = cola.sacar();
            historial.agregarCancion(cancionActual);
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    private void reproducirAnterior() {
        
    }

    private void verColaReproduccion() {
        System.out.println("COLA DE REPRODUCCIÓN:");
        cola.mostrarCola();
    }

    private void menuBiblioteca(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Crear nueva playlist");
            System.out.println("5. Añadir canción a playlist");
            System.out.println("6. Eliminar canción de playlist");
            System.out.println("7. Ver playlists");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarAFavoritas(scanner);
                    break;
                case 2:
                    eliminarDeFavoritas(scanner);
                    break;
                case 3:
                    biblioteca.mostrarCancionesFavoritas();
                    break;
                case 4:
                    crearPlaylist(scanner);
                    break;
                case 5:
                    anadirCancionAPlaylist(scanner);
                    break;
                case 6:
                    eliminarCancionDePlaylist(scanner);
                    break;
                case 7:
                    verPlaylists();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }

    private void agregarAFavoritas(Scanner scanner) {
        biblioteca.mostrarCanciones();
        System.out.print("Seleccione canción a añadir a favoritos: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < biblioteca.getCanciones().size()) {
            biblioteca.agregarAFavoritas(biblioteca.getCanciones().get(index));
            System.out.println("Canción añadida a favoritos.");
        } else {
            System.out.println("Canción no válida.");
        }
    }

    private void eliminarDeFavoritas(Scanner scanner) {
        biblioteca.mostrarCancionesFavoritas();
        System.out.print("Seleccione canción a eliminar de favoritos: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < biblioteca.getCancionesFavoritas().size()) {
            biblioteca.eliminarDeFavoritas(biblioteca.getCancionesFavoritas().get(index));
            System.out.println("Canción eliminada de favoritos.");
        } else {
            System.out.println("Canción no válida.");
        }
    }

    private void crearPlaylist(Scanner scanner) {
        System.out.print("Nombre de la nueva playlist: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    private void anadirCancionAPlaylist(Scanner scanner) {
        System.out.println("Funcionalidad no implementada.");
    }

    private void eliminarCancionDePlaylist(Scanner scanner) {
        System.out.println("Funcionalidad no implementada.");
    }

    private void verPlaylists() {
        System.out.println("Funcionalidad no implementada.");
    }
}

