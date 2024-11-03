package romeroAngel.reto004;

import java.util.Scanner;

import romeroAngel.reto_001.Cola;

public class SistemaReproduccion {
    
    private List canciones;
    private Playlist cancionesFavoritas;
    private List playlists;
    private List colaReproduccion;
    private Cancion cancionActual;
    private List historial;
    private boolean aleatorio;
    private boolean repeticion;
    private int indiceCancionActual;

    public SistemaReproduccion(){
        this.canciones = new List();
        this.playlists = new List();
        this.colaReproduccion = new List();
        this.cancionActual = null;
        this.aleatorio = false;
        this.repeticion = false;
        indiceCancionActual = -1;
    }

    public void mostrarMenuPrincipal(){
        Scanner scanner =  new Scanner(System.in);
        int opcion;

        do{
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción.");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuReproduccion();
                    break;
            
                case 2:
                    mostrarMenuBiblioteca();
                    break;
                
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                
                default:
                    System.out.println("Elija una opción válida");
            }
        } while (opcion != 3);
    }

    private void mostrarMenuBiblioteca() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
    
        do {
            System.out.println("=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Eliminar canción de favoritos");
            System.out.println("3. Ver canciones favoritas");
            System.out.println("4. Crear nueva playlist");
            System.out.println("5. Añadir canción a playlist");
            System.out.println("6. Eliminar canción de playlist");
            System.out.println("7. Ver playlists");
            System.out.println("8. Ver canciones de una playlist");
            System.out.println("9. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
    
            switch (opcion) {
                case 1:
                    añadirCancionAFavoritos();
                    break;
                case 2:
                    eliminarCancionDeFavoritos();
                    break;
                case 3:
                    verCancionesFavoritas();
                    break;
                case 4:
                    crearNuevaPlaylist();
                    break;
                case 5:
                    añadirCancionAPlaylist();
                    break;
                case 6:
                    eliminarCancionDePlaylist();
                    break;
                case 7:
                    verPlaylists();
                    break;
                case 8:
                    verCancionesDePlaylist();
                    break;
                case 9:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 9);
    }

    private void mostrarMenuReproduccion() {
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        do{
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Reproducir anterior");
            System.out.println("4. Ver cola de reproducción");
            System.out.println("5. Ver historial");
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
                    verHistorial();
                    break;
                case 6:
                    aleatorio = !aleatorio;
                    System.out.println("Modo aleatorio " + (aleatorio ? "activado." : "desactivado."));
                    break;
                case 7:
                    repeticion = !repeticion;
                    System.out.println("Modo repetición " + (repeticion ? "activado." : "desactivado."));
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
            
        } while(opcion != 8);
    }

    private void verHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial esta vacío.");
            return;
        }   

        System.out.println("=== HISTORIAL DE REPRODUCCIÓN ===");
        int index = 1;
        Node iterator = historial.getFirst();

        while (iterator != null) {
            Cancion cancion = iterator.getCancion();
            System.out.println(index + ". " + cancion.toString());
            iterator = iterator.getNext();
            index++;
        }
    }

    private void verColaReproduccion() {
        if (colaReproduccion.isEmpty()) {
            System.out.println("La cola de reproduccion esta vacía.");
            return;
        }

        System.out.println("=== COLA DE REPRODUCCIÓN ===");
        int index = 1;
        Node iterator = colaReproduccion.getFirst();

        while (iterator != null) {
            Cancion cancion = iterator.getCancion();
            if (cancion.equals(cancionActual)) {
                System.out.println(index + ". ▶ " + cancion.toString() + " (ACTUAL)");
            } else {
                System.out.println(index + ". " + cancion.toString());
            }
            iterator = iterator.getNext();
            index++;
        }

        System.out.println("\nEstado: Reproducción " + (aleatorio ? "aleatoria" : "normal") + " | Repetición: " + (repeticion ? "ON" : "OFF"));
    }

    private void reproducirAnterior() {
        if (indiceCancionActual > 0) {
            indiceCancionActual--;
        } else if (repeticion) {
            indiceCancionActual = canciones.size()-1;
        } else {
            System.out.println("Estas al inicio de la lista.");
            return;
        }

        cancionActual = canciones.obtener(indiceCancionActual);
        System.out.println("▶ Reproduciendo anterior: " + cancionActual.toString());
    }

    private void reproducirSiguiente() {
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones en la cola.");
            return;
        }

        if (aleatorio){
            if (historial.size() >= canciones.size()) {
                System.out.println("Todas las canciones han sido reproducidas. Reiniciando el historial.");
                historial.clear(); 
            }

            int indiceAleatorio;
            do{
                indiceAleatorio = (int)(Math.random()*canciones.size());
            } while(historial.contains(canciones.obtener(indiceAleatorio)));

            historial.insertEnd(canciones.obtener(indiceAleatorio));
            cancionActual = canciones.obtener(indiceAleatorio);
        } else {
            if (indiceCancionActual < canciones.size()-1) {
                indiceCancionActual++;
                cancionActual = canciones.obtener(indiceCancionActual);
            } else if (repeticion) {
                indiceCancionActual = 0;
                cancionActual = canciones.obtener(indiceCancionActual);
            } else {
                System.out.println("Ya estas en la ultima cancion de la playlist");
                return;
            }
        }

        System.out.println("▶ Reproduciendo siguiente: " + cancionActual.toString());
    }

    private void verCancionActual() {
        if (cancionActual != null) {
            System.out.println("▶ Reproduciendo: " + cancionActual.toString());
        }
    }
}
