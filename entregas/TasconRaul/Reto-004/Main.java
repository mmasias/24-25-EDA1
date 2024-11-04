import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Reproductor reproductor = new Reproductor(10, 10);
    private static final Biblioteca biblioteca = new Biblioteca(10);

    public static void main(String[] args) {
        inicializarBiblioteca();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarMenuReproduccion();
                    break;
                case 2:
                    mostrarMenuBiblioteca();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }
    }

    private static void inicializarBiblioteca() {
        biblioteca.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 355));
        biblioteca.agregarCancion(new Cancion("Stairway to Heaven", "Led Zeppelin", 482));
        biblioteca.agregarCancion(new Cancion("Imagine", "John Lennon", 183));
        biblioteca.agregarCancion(new Cancion("Hotel California", "Eagles", 391));
        biblioteca.agregarCancion(new Cancion("Sweet Child O' Mine", "Guns N' Roses", 356));
        biblioteca.agregarCancion(new Cancion("Billie Jean", "Michael Jackson", 294));
        biblioteca.agregarCancion(new Cancion("Like a Rolling Stone", "Bob Dylan", 369));
        biblioteca.agregarCancion(new Cancion("Smells Like Teen Spirit", "Nirvana", 301));
        biblioteca.agregarCancion(new Cancion("Wonderwall", "Oasis", 259));
        biblioteca.agregarCancion(new Cancion("Hey Jude", "The Beatles", 431));
    }

    private static void mostrarMenuReproduccion() {
        boolean volver = false;
        while (!volver) {
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
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    reproductor.verCancionActual();
                    break;
                case 2:
                    reproductor.reproducirSiguiente();
                    break;
                case 3:
                    reproductor.reproducirAnterior();
                    break;
                case 4:
                    reproductor.verCola();
                    break;
                case 5:
                    reproductor.verHistorial();
                    break;
                case 6:
                    System.out.print("¿Activar modo aleatorio? (s/n): ");
                    boolean estadoAleatorio = scanner.nextLine().equalsIgnoreCase("s");
                    reproductor.activarModoAleatorio(estadoAleatorio);
                    break;
                case 7:
                    System.out.print("¿Activar modo repetición? (s/n): ");
                    boolean estadoRepeticion = scanner.nextLine().equalsIgnoreCase("s");
                    reproductor.activarRepeticion(estadoRepeticion);
                    break;
                case 8:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenuBiblioteca() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Agregar canción a cola de reproducción");
            System.out.println("5. Ver todas las canciones");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione el número de la canción para marcar como favorita: ");
                    int indiceFavorita = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Cancion cancionFavorita = biblioteca.obtenerCancion(indiceFavorita);
                    if (cancionFavorita != null) {
                        cancionFavorita.toggleFavorita();
                        System.out.println("Canción marcada como favorita: " + cancionFavorita);
                    }
                    break;
                case 2:
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione el número de la canción para desmarcar como favorita: ");
                    int indiceNoFavorita = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Cancion cancionNoFavorita = biblioteca.obtenerCancion(indiceNoFavorita);
                    if (cancionNoFavorita != null && cancionNoFavorita.esFavorita()) {
                        cancionNoFavorita.toggleFavorita();
                        System.out.println("Canción eliminada de favoritos: " + cancionNoFavorita);
                    } else {
                        System.out.println("La canción no está en favoritos.");
                    }
                    break;
                case 3:
                    System.out.println("\n=== Canciones Favoritas ===");
                    for (int i = 0; i < biblioteca.getCantidadCanciones(); i++) {
                        Cancion cancion = biblioteca.obtenerCancion(i);
                        if (cancion != null && cancion.esFavorita()) {
                            System.out.println((i + 1) + ". " + cancion);
                        }
                    }
                    break;
                case 4:
                    biblioteca.mostrarCanciones();
                    System.out.print("Seleccione el número de la canción para añadir a la cola de reproducción: ");
                    int indiceCola = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Cancion cancionCola = biblioteca.obtenerCancion(indiceCola);
                    if (cancionCola != null) {
                        reproductor.agregarACola(cancionCola);
                    }
                    break;
                case 5:
                    biblioteca.mostrarCanciones();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
                    break;
            }
        }
    }
}
