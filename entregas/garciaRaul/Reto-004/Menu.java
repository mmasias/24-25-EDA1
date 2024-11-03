import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    int eleccion;
    Cancion currentSong;
    List canciones;
    String eleccionString;
    Cancion cancionActual;
    Canciones canciones;

    public Menu(Cancion cancionActual, Canciones canciones) {
        this.cancionActual = cancionActual;
    public Menu(Cancion currentSong, List canciones) {
        this.canciones = canciones;
        this.currentSong = currentSong;
        cleanScreen();
        menuPrincipal();
        mainMenu();
    }
}

    public void menuPrincipal() {
        System.out.println(
                        "=== MENÚ PRINCIPAL ===\n" + //
                        "1. Reproducción\n" + //
                        "2. Biblioteca\n" + //
                        "3. Salir"
                        );
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
}

    public void menuBiblioteca(){
        System.out.println(
                        "=== MENÚ BIBLIOTECA ===\n" + //
                        "1. Añadir canción a favoritos\n" + //
                        "2. Eliminar canción de favoritos\n" + //
                        "3. Ver canciones favoritas\n" + //
                        "4. Crear nueva playlist\n" + //
                        "5. Añadir canción a playlist\n" + //
                        "6. Eliminar canción de playlist\n" + //
                        "7. Ver playlists\n" + //
                        "8. Ver canciones de una playlist\n" + //
                        "9. Volver al menú principal"
                        );
        System.out.print("Seleccione una opción: ");
        eleccion = scanner.nextInt();
    }
    
    public void menuReproduccion() {
        System.out.println(
                        "=== MENÚ REPRODUCCIÓN ===\n" + //
                "=== MENÚ REPRODUCCIÓN ===\n" + //
                        "1. Ver canción actual\n" + //
                        "2. Reproducir siguiente\n" + //
                        "3. Reproducir anterior\n" + //
                        "4. Ver cola de reproducción\n" + //
                        "5. Ver historial\n" + //
                        "6. Activar/desactivar aleatorio\n" + //
                        "7. Activar/desactivar repetición\n" + //
                        "8. Volver al menú principal"
                        );
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
                menuBiblioteca();
                break;
            case 3:
                cleanScreen();
                menuBiblioteca();
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
                menuPrincipal();
                mainMenu();
                break;
            default:
                break;
        }
    }

    private void verCancionActual() {
        if(cancionActual == null){
        if(currentSong == null){
            System.out.println("No hay canciones en reproducción\n");
            System.out.print("¿Desea comenzar a reproducir? (S/N): ");
            eleccionString = scanner.nextLine();
            System.out.println();
        }else{
            System.out.println("Estas reproduciendo " + cancionActual);
            System.out.println("Estas reproduciendo " + currentSong);
        }

        switch (eleccionString) {
            case "s":
                reproducirCancion();
                break;

            default:
                menuPrincipal();
                mainMenu();
                break;
        }
    }

    private void reproducirCancion() {
        System.out.println("Eljije la canción que quieres reproducir:\n");
        System.out.println(canciones.todasLasCanciones().mostrar());
    private void reproducirCancion(){
        System.out.println(canciones.mostrar());
    }


        eleccion = scanner.nextInt();
        scanner.nextLine();
    public void menuBiblioteca() {

        cancionActual = canciones.todasLasCanciones().
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
}