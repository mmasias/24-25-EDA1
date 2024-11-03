package reto004;

import java.util.Scanner;

public class Spotify {
    private ListaReproduccion listaReproduccion;
    private Scanner scanner;
    private Thread reproduccionThread;

    public Spotify() {
        listaReproduccion = new ListaReproduccion();
        scanner = new Scanner(System.in);
        listaReproduccion.agregarCancion("esclava remix - bryant myers", 278);
        listaReproduccion.agregarCancion("SEDA - bad bunny", 170);
        listaReproduccion.agregarCancion("hollywood - kaydy cain", 173);
    }

    public void menuPrincipal() {
        while (true) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuReproduccion();
                    break;
                case 2:
                    menuBiblioteca();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public void menuReproduccion() {
        while (true) {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Siguiente canción");
            System.out.println("2. Canción anterior");
            System.out.println("3. Ver lista de canciones");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listaReproduccion.siguienteCancion();
                    reproducirCancion();
                    break;
                case 2:
                    listaReproduccion.anteriorCancion();
                    reproducirCancion();
                    break;
                case 3:
                    listaReproduccion.mostrarCanciones();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public void reproducirCancion() {
        if (reproduccionThread != null && reproduccionThread.isAlive()) {
            return;
        }

        Cancion cancionActual = listaReproduccion.getCancionActual();
        if (cancionActual != null) {
            System.out.println("Reproduciendo: " + cancionActual.getNombre());
            reproduccionThread = new Thread(() -> {
                try {
                    Thread.sleep(cancionActual.getDuracion() * 1000);
                    listaReproduccion.siguienteCancion();
                    reproducirCancion();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            reproduccionThread.start();
        }
    }

    public void menuBiblioteca() {
        while (true) {
            System.out.println("=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Ver canciones favoritas");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Canciones disponibles:");
                    listaReproduccion.mostrarCanciones();
                    System.out.print("Seleccione el índice de la canción que desea añadir a favoritos: ");
                    int indice = scanner.nextInt();
                    listaReproduccion.agregarAFavoritos(indice);
                    break;
                case 2:
                    System.out.println("Canciones favoritas:");
                    listaReproduccion.mostrarFavoritos();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Spotify spotify = new Spotify();
        spotify.menuPrincipal();
    }
}
