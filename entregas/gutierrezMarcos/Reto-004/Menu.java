import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    int eleccion;
    Cancion currentSong;
    List canciones;
    String eleccionString;

    public Menu(Cancion currentSong, List canciones) {
        this.canciones = canciones;
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
                menuBiblioteca();
                break;
            case 5:
                cleanScreen();
                menuBiblioteca();
                break;
            case 6:
                cleanScreen();
                menuBiblioteca();
                break;
            case 7:
                cleanScreen();
                menuBiblioteca();
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
        pause(3);
        cleanScreen();
        menuReproduccion();
    }

    private void reproducirSiguiente(){

        if (currentSong != null) {
            currentSong = canciones.next(currentSong);
            System.out.println("Estas reproduciendo " + currentSong.toString());
        } else {
            System.out.println("No hay más canciones en la lista.");
        }
        pause(3);
        cleanScreen();
        menuReproduccion();
    }

    private void reproducirAnterior(){

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

    public void menuBiblioteca() {

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