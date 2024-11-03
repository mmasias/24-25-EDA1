package reto004;

import java.util.Scanner;

public class SpotifyApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ListaCanciones biblioteca = new ListaCanciones();
    private static ColaReproduccion colaReproduccion = new ColaReproduccion();
    private static PilaHistorial historial = new PilaHistorial();

    public static void main(String[] args) {
        inicializarBiblioteca();

        int opcionPrincipal;
        do {
            mostrarBibliotecaInicial();
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcionPrincipal) {
                case 1:
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 3);
    }

    private static void inicializarBiblioteca() {
        biblioteca.agregarCancion(new Cancion("Smell like teen spirit", "Nirvana", 290));
        biblioteca.agregarCancion(new Cancion("Bleed it out", "Linkin Park", 277));
        biblioteca.agregarCancion(new Cancion("505", "Artic Monkeys", 344));
        biblioteca.agregarCancion(new Cancion("Highway to hell", "AC/DC", 392));
        biblioteca.agregarCancion(new Cancion("I was made for lovin you", "Kiss", 275));
        biblioteca.agregarCancion(new Cancion("Livin’ on a Prayer", "Bon Jovi", 222));
        biblioteca.agregarCancion(new Cancion("Immigrant Song", "Led Zeppelin", 273));
        biblioteca.agregarCancion(new Cancion("Welcome to the jungle", "Guns n Roses", 266));
        biblioteca.agregarCancion(new Cancion("American Idiot", "Green Day", 235));
        biblioteca.agregarCancion(new Cancion("Bloody Valentine", "MGK", 325));
    }
}