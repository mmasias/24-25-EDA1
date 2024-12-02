import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaReproduccion {
    private static ListaDobleEnlazada colaReproduccion = new ListaDobleEnlazada();
    private static PilaHistorial historial = new PilaHistorial();
    private static Biblioteca biblioteca;
    private static boolean modoAleatorio = false;
    private static boolean modoRepeticion = false;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== SPOTIFY ===");

        List<Cancion> cancionesDisponibles = new ArrayList<>();
        cancionesDisponibles.add(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        cancionesDisponibles.add(new Cancion("Los Dinosaurios", "Charly García", 234));
        cancionesDisponibles.add(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        cancionesDisponibles.add(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        cancionesDisponibles.add(new Cancion("No Soy Un Extraño", "Charly García", 295));
        cancionesDisponibles.add(new Cancion("Seminare", "Serú Girán", 238));
        cancionesDisponibles.add(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        cancionesDisponibles.add(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        cancionesDisponibles.add(new Cancion("Película sordomuda", "Charly García", 235));
        cancionesDisponibles.add(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));

        biblioteca = new Biblioteca(cancionesDisponibles);

        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Reproducción");
        System.out.println("2. Biblioteca");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                menuReproduccion();
                break;
            case 2:
                menuBiblioteca();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida.");
                mostrarMenuPrincipal();
        }
    }

    private static void menuReproduccion() {
        System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
        System.out.println("1. Ver canción actual");
        System.out.println("2. Reproducir siguiente");
        System.out.println("3. Reproducir anterior");
        System.out.println("4. Ver cola de reproducción");
        System.out.println("5. Ver historial de reproducción");
        System.out.println("6. Activar/desactivar modo aleatorio");
        System.out.println("7. Activar/desactivar repetición");
        System.out.println("8. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Reproduciendo: " + colaReproduccion.verActual());
                break;
            case 2:
                reproducirSiguiente();
                break;
            case 3:
                reproducirAnterior();
                break;
            case 4:
                colaReproduccion.mostrarCola();
                break;
            case 5:
                historial.mostrarHistorial();
                break;
            case 6:
                toggleModoAleatorio();
                break;
            case 7:
                toggleModoRepeticion();
                break;
            case 8:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción inválida.");
                menuReproduccion();
        }
    }

    private static void reproducirSiguiente() {
        if (modoRepeticion) {
            System.out.println("Reproduciendo nuevamente: " + colaReproduccion.verActual());
        } else if (modoAleatorio) {
            reproducirAleatorio();
        } else {
            Cancion siguiente = colaReproduccion.siguiente();
            if (siguiente != null) {
                historial.agregarHistorial(siguiente);
                System.out.println("Reproduciendo siguiente canción: " + siguiente);
            } else {
                System.out.println("No hay más canciones en la cola.");
            }
        }
    }

    private static void reproducirAnterior() {
        Cancion anterior = colaReproduccion.anterior();
        if (anterior != null) {
            historial.agregarHistorial(anterior);
            System.out.println("Reproduciendo canción anterior: " + anterior);
        } else {
            System.out.println("No hay canciones anteriores en la cola.");
        }
    }

    private static void reproducirAleatorio() {
        int index = random.nextInt(10);
        Nodo temporal = colaReproduccion.inicio;
        for (int i = 0; i < index; i++) {
            temporal = temporal.siguiente;
        }
        System.out.println("Reproduciendo canción aleatoria: " + temporal.cancion);
    }

    private static void toggleModoAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("Modo aleatorio " + (modoAleatorio ? "activado" : "desactivado") + ".");
    }

    private static void toggleModoRepeticion() {
        modoRepeticion = !modoRepeticion;
        System.out.println("Modo repetición " + (modoRepeticion ? "activado" : "desactivado") + ".");
    }

    private static void menuBiblioteca() {
        System.out.println("\n=== MENÚ BIBLIOTECA ===");
        System.out.println("1. Ver canciones favoritas");
        System.out.println("2. Añadir canción a favoritos");
        System.out.println("3. Eliminar canción de favoritos");
        System.out.println("4. Crear nueva playlist");
        System.out.println("5. Añadir canción a playlist");
        System.out.println("6. Eliminar canción de playlist");
        System.out.println("7. Ver playlists");
        System.out.println("8. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                biblioteca.mostrarFavoritos();
                break;
                case 2:
                seleccionarCancionParaAgregarAFavoritos();
                break;
            case 3:
                seleccionarCancionParaEliminarDeFavoritos();
                break;
            case 4:
                System.out.print("Ingrese el índice de la playlist (0-9): ");
                int indice = scanner.nextInt();
                biblioteca.crearPlaylist(indice);
                break;
            case 5:
                System.out.print("Ingrese el índice de la playlist (0-9): ");
                int indiceAgregar = scanner.nextInt();
                Cancion cancionPlaylist = new Cancion("Demoliendo Hoteles", "Charly García", 258);
                biblioteca.agregarAPlaylist(indiceAgregar, cancionPlaylist);
                break;
            case 6:
                System.out.print("Ingrese el índice de la playlist (0-9): ");
                int indiceEliminar = scanner.nextInt();
                Cancion cancionEliminar = new Cancion("Demoliendo Hoteles", "Charly García", 258);
                biblioteca.eliminarDePlaylist(indiceEliminar, cancionEliminar);
                break;
            case 7:
                System.out.print("Ingrese el índice de la playlist (0-9): ");
                int indiceVer = scanner.nextInt();
                biblioteca.mostrarPlaylist(indiceVer);
                break;
            case 8:
                mostrarMenuPrincipal();
                break;
            default:
                System.out.println("Opción inválida.");
                menuBiblioteca();
        }
    }

    private static void seleccionarCancionParaAgregarAFavoritos() {
        System.out.println("\nSeleccione una canción para agregar a favoritos:");
        List<Cancion> canciones = biblioteca.getCancionesDisponibles();
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println((i + 1) + ". " + canciones.get(i));
        }

        System.out.print("Ingrese el número de la canción: ");
        int indice = scanner.nextInt() - 1;
        if (indice >= 0 && indice < canciones.size()) {
            Cancion cancion = canciones.get(indice);
            biblioteca.agregarAFavoritos(cancion);
        } else {
            System.out.println("Índice de canción inválido.");
        }
    }

    private static void seleccionarCancionParaEliminarDeFavoritos() {
        System.out.println("\nSeleccione una canción para eliminar de favoritos:");
        List<Cancion> canciones = biblioteca.getCancionesDisponibles();
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).esFavorita()) {
                System.out.println((i + 1) + ". " + canciones.get(i));
            }
        }

        System.out.print("Ingrese el número de la canción: ");
        int indice = scanner.nextInt() - 1;
        if (indice >= 0 && indice < canciones.size()) {
            Cancion cancion = canciones.get(indice);
            if (cancion.esFavorita()) {
                biblioteca.eliminarDeFavoritos(cancion);
            } else {
                System.out.println("La canción seleccionada no está en favoritos.");
            }
        } else {
            System.out.println("Índice de canción inválido.");
        }
    }
}