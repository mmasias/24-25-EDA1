package entregas.atecaAlejandro.reto004;

import java.util.Scanner;

public class SistemaReproduccion {
    private static Cola colaReproduccion;
    private static boolean modoAleatorio = false;
    private static boolean modoRepetir = false;
    private static Playlist playlistFavoritas;

    public static void main(String[] args) {
        colaReproduccion = new Cola();
        playlistFavoritas = new Playlist("Favoritas");

        inicializarCanciones();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenuPrincipal(scanner);
        }
    }

    private static void inicializarCanciones() {
        colaReproduccion.agregar(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        colaReproduccion.agregar(new Cancion("Los Dinosaurios", "Charly García", 234));
        colaReproduccion.agregar(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        colaReproduccion.agregar(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        colaReproduccion.agregar(new Cancion("No Soy Un Extraño", "Charly García", 295));
        colaReproduccion.agregar(new Cancion("Seminare", "Serú Girán", 238));
        colaReproduccion.agregar(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        colaReproduccion.agregar(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        colaReproduccion.agregar(new Cancion("Película sordomuda", "Charly García", 235));
        colaReproduccion
                .agregar(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));
    }

    private static void mostrarMenuPrincipal(Scanner scanner) {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Reproducción");
        System.out.println("2. Biblioteca");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            mostrarMenuReproduccion(scanner);
        } else if (opcion == 2) {
            mostrarMenuBiblioteca(scanner);
        } else if (opcion == 3) {
            System.exit(0);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void mostrarMenuReproduccion(Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Ver cola de reproducción");
            System.out.println("4. Activar/desactivar aleatorio");
            System.out.println("5. Activar/desactivar repetición");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                Cancion cancionActual = colaReproduccion.siguiente();
                if (cancionActual != null) {
                    System.out.println("▶ Reproduciendo: " + cancionActual);
                } else {
                    System.out.println("No hay canción en reproducción.");
                }
            } else if (opcion == 2) {
                Cancion cancionSiguiente = colaReproduccion.siguiente();
                if (cancionSiguiente != null) {
                    System.out.println("▶ Reproduciendo: " + cancionSiguiente);
                } else {
                    System.out.println("No hay más canciones en la cola.");
                }
            } else if (opcion == 3) {
                System.out.println("COLA DE REPRODUCCIÓN:");
                colaReproduccion.mostrarCola();
            } else if (opcion == 4) {
                modoAleatorio = !modoAleatorio;
                System.out.println("Modo aleatorio: " + (modoAleatorio ? "ACTIVADO" : "DESACTIVADO"));
            } else if (opcion == 5) {
                modoRepetir = !modoRepetir;
                System.out.println("Modo repetición: " + (modoRepetir ? "ACTIVADO" : "DESACTIVADO"));
            } else if (opcion == 6) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenuBiblioteca(Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Crear nueva playlist");
            System.out.println("5. Añadir canción a playlist");
            System.out.println("6. Eliminar canción de playlist");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    añadirCancionAFavoritos(scanner);
                    break;
                case 2:
                    eliminarCancionDeFavoritos(scanner);
                    break;
                case 3:
                    System.out.println("CANCIONES FAVORITAS:");
                    playlistFavoritas.mostrarCanciones();
                    break;
                case 4:

                case 5:

                    break;
                case 6:

                case 7:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void añadirCancionAFavoritos(Scanner scanner) {
        System.out.println("Seleccione el número de la canción para añadir a favoritos:");
        colaReproduccion.mostrarCola();
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= colaReproduccion.size()) {
            System.out.println("Número de canción no válido.");
            return;
        }

        Cancion cancionFavorita = null;
        Nodo actual = colaReproduccion.getFrente();

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                cancionFavorita = actual.cancion;
                break;
            }
            actual = actual.siguiente;
        }

        if (cancionFavorita != null) {
            cancionFavorita.setFavorita(true);
            playlistFavoritas.agregarCancion(cancionFavorita);
            System.out.println("Canción añadida a favoritos: " + cancionFavorita);
        }
    }

    private static void eliminarCancionDeFavoritos(Scanner scanner) {
        System.out.println("Seleccione el número de la canción para eliminar de favoritos:");
        playlistFavoritas.mostrarCanciones();
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= playlistFavoritas.size()) {
            System.out.println("Número de canción no válido.");
            return;
        }

        Cancion cancionEliminada = playlistFavoritas.getCancion(index);
        cancionEliminada.setFavorita(false);
        playlistFavoritas.removeCancion(index);
        System.out.println("Canción eliminada de favoritos: " + cancionEliminada);
    }
}