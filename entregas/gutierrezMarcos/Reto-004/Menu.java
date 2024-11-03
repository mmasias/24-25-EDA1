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

    public Menu(Cancion currentSong, List canciones) {
        this.canciones = canciones;
        this.historial = new List();
        this.favoritos = new List();
        this.currentSong = currentSong;
        cleanScreen();
        mainMenu();
    }

    public void mainMenu() {
        System.out.println("=== MENÚ PRINCIPAL ===\n" + //
                "1. Reproducción\n" + //
                "2. Biblioteca\n" + //
                "3. Salir");

        System.out.print("Seleccione una opción: ");
        eleccion = scanner.nextInt();
        scanner.nextLine();

        switch (eleccion) {
            case 1:
                cleanScreen();
                menuReproduccion();
                break;
            case 2:
                cleanScreen();
                menuBiblioteca();
                break;

            default:
                break;
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
        eleccion = scanner.nextInt();
        scanner.nextLine();

        switch (eleccion) {
            case 1:
                cleanScreen();
                verCancionActual();
                break;
            case 2:
                cleanScreen();
                reproducirSiguiente();
                break;
            case 3:
                cleanScreen();
                reproducirAnterior();
                break;
            case 4:
                cleanScreen();
                mostrarCola();
                break;
            case 5:
                cleanScreen();
                verHistorial();
                break;
            case 6:
                cleanScreen();
                toggleAleatorio();
                break;
            case 7:
                cleanScreen();
                toggleRepeticion();
                break;
            case 8:
                cleanScreen();
                mainMenu();
                break;
            default:
                break;
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
            case "S":
                reproducirCancion();
                break;

            default:
                mainMenu();
                break;
        }
    }

    private void reproducirCancion() {
        System.out.println(canciones.mostrar());

        eleccion = scanner.nextInt();
        scanner.nextLine();

        currentSong = canciones.getCancion(eleccion);

        System.out.println("Estas reproduciendo " + currentSong.toString());
        historial.insertEnd(currentSong);
        pause(3);
        cleanScreen();
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
        pause(3);
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
        pause(3);
        cleanScreen();
        menuReproduccion();
    }

    private void mostrarCola() {
        if (currentSong != null) {
            System.out.println(canciones.mostrarDesde(currentSong.toString()));
            scanner.nextLine();
        } else {
            System.out.println("No tienes ninguna canción ni ninguna lista en reproducción");
            pause(3);
        }
        cleanScreen();
        menuReproduccion();
    }

    private void verHistorial() {
        if(historial != null){
            System.out.println("=== Historial de Canciones Reproducidas ===");
            System.out.println(historial.mostrar());
            scanner.nextLine();
            cleanScreen();
            menuReproduccion();
        }
        else{
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
        eleccion = scanner.nextInt();
        scanner.nextLine();

        switch (eleccion) {
            case 1:
                cleanScreen();
                añadirCancionAFavoritos();
                break;
            case 2:
                cleanScreen();
                eliminarCancionDeFavoritos();
                break;
            case 3:
                cleanScreen();
                verCancionesFavoritas();
                break;
            case 4:
                cleanScreen();
                crearPlaylist();
                break;
            case 5:
                cleanScreen();
                añadirCancionAPlaylist();
                break;
            case 6:
                cleanScreen();
                eliminarCancionDePlaylist();
                break;
            case 7:
                cleanScreen();
                verPlaylists();
                break;
            case 8:
                cleanScreen();
                verCancionesDePlaylist();
                break;
            case 9:
                cleanScreen();
                mainMenu();
                break;
            default:
                break;
        }
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
}