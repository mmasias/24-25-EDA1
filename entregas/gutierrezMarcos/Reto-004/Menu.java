import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    int eleccion;
    Cancion currentSong;
    List canciones;
    List historial;
    List favoritos;
    String eleccionString;
    boolean aleatorioActivado = false;
    boolean repetirActivado = false;
    private List playlists = new List();

    public Menu(Cancion currentSong, List canciones) {
        this.canciones = canciones;
        this.historial = new List();
        this.favoritos = new List();
        this.currentSong = currentSong;
        cleanScreen();
        mainMenu();
    }

    private void eleccion(){
        eleccion = scanner.nextInt();
        scanner.nextLine();
        pause(2);
        cleanScreen();
    }

    public void mainMenu() {
        System.out.println("=== MENÚ PRINCIPAL ===\n" + //
                "1. Reproducción\n" + //
                "2. Biblioteca\n" + //
                "3. Salir");

        System.out.print("Seleccione una opción: ");
        eleccion();

        switch (eleccion) {
            case 1 -> menuReproduccion();
            case 2 -> menuBiblioteca();
            case 3 -> System.exit(0);
            default -> System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    public void menuReproduccion() {
        System.out.println(
                "=== MENÚ REPRODUCCIÓN ===\n" + //
                        "1. Ver canción actual\n" + //
                        "2. Reproducir siguiente\n" + //
                        "3. Reproducir anterior\n" + //
                        "4. Ver cola de reproducción\n" + //
                        "5. Ver historial\n" + //
                        "6. Activar/desactivar aleatorio\n" + //
                        "7. Activar/desactivar repetición\n" + //
                        "8. Volver al menú principal");

        System.out.print("Seleccione una opción: ");
        eleccion();

        switch (eleccion) {
            case 1 -> verCancionActual();
            case 2 -> reproducirSiguiente();
            case 3 -> reproducirAnterior();
            case 4 -> mostrarCola();
            case 5 -> verHistorial();
            case 6 -> toggleAleatorio();
            case 7 -> toggleRepeticion();
            case 8 -> mainMenu();
            default -> menuReproduccion();
        }
    }

    private void verCancionActual() {
        if (currentSong == null) {
            System.out.println("No hay canciones en reproducción\n");
            System.out.print("¿Desea comenzar a reproducir? (S/N): ");
            eleccionString = scanner.nextLine();
            System.out.println();
        } else {
            System.out.println("Estas reproduciendo " + currentSong.toString());
        }

        switch (eleccionString.toUpperCase()) {
            case "S" -> reproducirCancion();
            default -> mainMenu();

        }
    }

    private void reproducirCancion() {
        System.out.println(canciones.mostrar());
        eleccion();

        currentSong = canciones.getCancion(eleccion);

        System.out.println("Estas reproduciendo " + currentSong.toString());
        historial.insertEnd(currentSong);
        menuReproduccion();
    }

    private void reproducirSiguiente() {
        if (currentSong != null) {
            currentSong = canciones.next(currentSong);
            System.out.println("Estas reproduciendo " + currentSong.toString());
            historial.insertEnd(currentSong);
        } else {
            System.out.println("No hay más canciones en la lista.");
        }
        pause(2);
        cleanScreen();
        menuReproduccion();
    }

    private void reproducirAnterior() {
        if (currentSong != null) {
            currentSong = canciones.previous(currentSong);
            System.out.println("Estas reproduciendo " + currentSong.toString());
        } else {
            System.out.println("No hay más canciones en la lista.");
        }
        pause(2);
        cleanScreen();
        menuReproduccion();
    }

    private void mostrarCola() {
        if (currentSong != null) {
            System.out.println(canciones.mostrarDesde(currentSong.toString()));
            scanner.nextLine();
        } else {
            System.out.println("No tienes ninguna canción ni ninguna lista en reproducción");
            pause(2);
        }
        cleanScreen();
        menuReproduccion();
    }

    private void verHistorial() {
        if (historial != null) {
            System.out.println("=== Historial de Canciones Reproducidas ===");
            System.out.println(historial.mostrar());
            scanner.nextLine();
            cleanScreen();
            menuReproduccion();
        } else {
            System.out.println("No tienes historial de reproduccion");
        }
    }

    private void toggleAleatorio() {
        aleatorioActivado = !aleatorioActivado;
        System.out.println("Aleatorio " + (aleatorioActivado ? "activado" : "desactivado"));
        pause(2);
        cleanScreen();
        menuReproduccion();
    }

    private void toggleRepeticion() {
        repetirActivado = !repetirActivado;
        System.out.println("Repetición " + (repetirActivado ? "activada" : "desactivada"));
        pause(2);
        cleanScreen();
        menuReproduccion();
    }

    public void menuBiblioteca() {
        System.out.println("=== MENÚ BIBLIOTECA ===\n" + //
                "1. Añadir canción a favoritos\n" + //
                "2. Eliminar canción de favoritos\n" + //
                "3. Ver canciones favoritas\n" + //
                "4. Crear nueva playlist\n" + //
                "5. Añadir canción a playlist\n" + //
                "6. Eliminar canción de playlist\n" + //
                "7. Ver playlists\n" + //
                "8. Ver canciones de una playlist\n" + //
                "9. Volver al menú principal");

        System.out.print("Seleccione una opción: ");
        eleccion();

        switch (eleccion) {
            case 1 -> añadirCancionAFavoritos();
            case 2 -> eliminarCancionDeFavoritos();
            case 3 -> verCancionesFavoritas();
            case 4 -> crearPlaylist();
            case 5 -> agregarCancionAPlaylist();
            case 6 -> eliminarCancionDePlaylist();
            case 7 -> verPlaylists();
            case 8 -> verCancionesEnPlaylist();
            case 9 -> mainMenu();
            default -> menuBiblioteca();
        }
    }

    private void añadirCancionAFavoritos() {
        System.out.println("Seleccione una canción para añadir a favoritos:");
        System.out.println(canciones.mostrar());

        eleccion();

        Cancion seleccionada = canciones.getCancion(eleccion);
        if (seleccionada != null && !seleccionada.isFavorita()) {
            seleccionada.setFavorita(true);
            System.out.println("Canción añadida a favoritos: " + seleccionada);
        } else {
            System.out.println("La canción ya está en favoritos o no es válida.");
        }
        menuBiblioteca();
    }

    private void verCancionesFavoritas() {
        System.out.println("=== Canciones Favoritas ===");
        System.out.println(canciones.mostrarFavoritas());

        scanner.nextLine();
        cleanScreen();
        menuBiblioteca();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(int segundos) {
        try {
            Thread.sleep(1000 * segundos);
        } catch (InterruptedException e) {
        }
    }

    private void crearPlaylist() {
        System.out.print("Ingrese el nombre de la nueva playlist: ");
        String nombrePlaylist = scanner.nextLine();
        playlists.crearPlaylist(new List(nombrePlaylist));
        System.out.println("Playlist creada.");
    }

    private void agregarCancionAPlaylist() {
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        List playlist = encontrarPlaylist(nombrePlaylist);
        if (playlist != null) {
            System.out.print("Ingrese el título de la canción: ");
            eleccion();
            Cancion cancion = canciones.getCancion(eleccion);
            if (cancion != null) {
                playlist.add(cancion);
                System.out.println("Canción añadida a la playlist.");
            } else {
                System.out.println("Canción no encontrada.");
            }
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    private void eliminarCancionDePlaylist() {
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        List playlist = encontrarPlaylist(nombrePlaylist);
        if (playlist != null) {
            System.out.print("Ingrese el título de la canción a eliminar: ");
            eleccion();
            playlist.remove(eleccion);
            System.out.println("Canción eliminada de la playlist.");
        } else {
            System.out.println("Playlist no encontrada.");
        }
        menuBiblioteca();
    }

    private void verPlaylists() {
        System.out.println("=== Playlists ===");
        Node current = playlists.getFirst();
        int indice = 1;
        while (current != null) {
            System.out.println(indice + ". " + current.getPlaylist().getName());
            current = current.getNext();
            indice++;
        }
        scanner.nextLine();
        menuBiblioteca();
    }

    private void verCancionesEnPlaylist() {
        System.out.print("Ingrese el nombre de la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        List playlist = encontrarPlaylist(nombrePlaylist);
        if (playlist != null) {
            System.out.println(playlist.mostrarCanciones());
        } else {
            System.out.println("Playlist no encontrada.");
            mainMenu();
        }
    }

    private List encontrarPlaylist(String nombre) {
        Node current = playlists.getFirst();
        while (current != null) {
            if (current.getPlaylist().getName().equalsIgnoreCase(nombre)) {
                return current.getPlaylist();
            }
            current = current.getNext();
        }
        return null;
    }

    private void eliminarCancionDeFavoritos() {
        System.out.println("=== Canciones Favoritas ===");
        String cancionesFavoritas = canciones.mostrarFavoritas();

        if (cancionesFavoritas.isEmpty()) {
            System.out.println("No hay canciones favoritas para eliminar.");
            return;
        }

        System.out.print("Seleccione el índice de la canción a eliminar de favoritos: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        Cancion cancion = canciones.getCancion(indice);

        if (cancion != null) {
            cancion.setFavorita(false);
            System.out.println("Canción eliminada de favoritos.");
        } else {
            System.out.println("Índice no válido.");
        }
    }
}