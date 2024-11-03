package entregas.grizoniManuela.reto004;

import java.util.Scanner;

public class Reproductor {

    private Scanner sc; 

    private Biblioteca biblioteca;
    private Playlist[] playlists;
    private Fila colaReproduccion;  
    private Historial historial;    
    private Cancion cancionActual;
    private Cancion cancionAnterior;
    private int numPlaylists;

    public Reproductor() {

        sc = new Scanner(System.in);

        biblioteca = new Biblioteca(10);   
        playlists = new Playlist[5];       
        colaReproduccion = new Fila(10);   
        historial = new Historial(10);     
        cancionActual = null;
        cancionAnterior = null;
        numPlaylists = 0;
        inicializarBiblioteca();
    }

   
    private void inicializarBiblioteca() {
        Album charlyAlbum = new Album("Clics Modernos", "Charly García", 1983);
        Album suiAlbum = new Album("Confesiones de Invierno", "Sui Generis", 1973);

        biblioteca.agregarCancion(new Cancion("Demoliendo Hoteles", charlyAlbum, 258));
        biblioteca.agregarCancion(new Cancion("Los Dinosaurios", charlyAlbum, 234));
        biblioteca.agregarCancion(new Cancion("Rasguña Las Piedras", suiAlbum, 285));
        biblioteca.agregarCancion(new Cancion("Canción Para Mi Muerte", suiAlbum, 342));
        biblioteca.agregarCancion(new Cancion("No Soy Un Extraño", charlyAlbum, 295));
        biblioteca.agregarCancion(new Cancion("Seminare", new Album("Bicicleta", "Serú Girán", 1980), 238));
        biblioteca.agregarCancion(new Cancion("Promesas Sobre El Bidet", charlyAlbum, 243));
        biblioteca.agregarCancion(new Cancion("Rezo Por Vos", new Album("Clics Modernos", "Charly García & Luis Alberto Spinetta", 1983), 266));
        biblioteca.agregarCancion(new Cancion("Película sordomuda", charlyAlbum, 235));
        biblioteca.agregarCancion(new Cancion("¿Qué se puede hacer salvo ver películas?", new Album("La máquina de hacer pájaros", "La máquina de hacer pájaros", 1976), 325));
    }

   
    private void mostrarBibliotecaInicial() {
        System.out.println("=== SPOTIFY  ===");
        System.out.println("\nBIBLIOTECA INICIAL\n");
        System.out.println("Canciones disponibles:\n");
        biblioteca.mostrarCanciones(); 
    }

   
    public void mostrarMenuPrincipal() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            mostrarBibliotecaInicial(); 

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Reproducción");
                System.out.println("2. Biblioteca");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarMenuReproduccion();
                        break;
                    case 2:
                        mostrarMenuBiblioteca();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while (opcion != 3);
        }
    }

    
    private void mostrarMenuReproduccion() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("\n=== MENÚ REPRODUCCIÓN ===");
                System.out.println("1. Ver canción actual");
                System.out.println("2. Reproducir siguiente");
                System.out.println("3. Reproducir anterior");
                System.out.println("4. Ver cola de reproducción");
                System.out.println("5. Ver historial");
                System.out.println("6. Activar/desactivar aleatorio");
                System.out.println("7. Activar/desactivar repetición");
                System.out.println("8. Volver al menú principal");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarCancionActual();
                        break;
                    case 2:
                        reproducirSiguiente();
                        break;
                    case 3:
                        reproducirAnterior();
                        break;
                    case 4:
                        colaReproduccion.mostrarFila();
                        break;
                    case 5:
                        historial.mostrarHistorial();
                        break;
                    case 8:
                        return;  
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while (true);
        }
    }
                    
 
    private void mostrarCancionActual() {
        if (cancionActual == null) {
            System.out.println("No hay canción en reproducción.");
        } else {
            System.out.println("▶ Reproduciendo: " + cancionActual.toString());
        }
    }

    
    private void reproducirSiguiente() {
        Cancion siguiente = colaReproduccion.desencolar();
        if (siguiente != null) {
            cancionAnterior = cancionActual; 
            cancionActual = siguiente;
            historial.agregarCancion(cancionActual);
            System.out.println("▶ Reproduciendo: " + cancionActual.toString());
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }


    

   
    private void reproducirAnterior() {
        if (cancionAnterior != null) {
            cancionActual = cancionAnterior;
            historial.agregarCancion(cancionActual); 
            System.out.println("▶ Reproduciendo anterior: " + cancionActual.toString());
        } else {
            System.out.println("No hay canción anterior para reproducir.");
        }
    }

   
    
    
    private void mostrarMenuBiblioteca() {
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("\n=== MENÚ BIBLIOTECA ===");
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
                opcion = sc.nextInt();

                switch (opcion) {
                    case 4:
                        crearNuevaPlaylist();
                        break;
                    case 5:
                        añadirCancionAPlaylist();
                        break;
                    case 9:
                        return;  
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while (true);
        }
    }

    // Lógica para crear una nueva playlist
    private void crearNuevaPlaylist() {
        try (Scanner sc = new Scanner(System.in)) {
            if (numPlaylists < playlists.length) {
                System.out.print("Nombre de la nueva playlist: ");
                String nombre = sc.nextLine();
                playlists[numPlaylists] = new Playlist(nombre, 10);  
                System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
                numPlaylists++;
            } else {
                System.out.println("No se pueden crear más playlists.");
            }
        }
    }

    
    private void añadirCancionAPlaylist() {
        try (Scanner sc = new Scanner(System.in)) {
            if (numPlaylists == 0) {
                System.out.println("No hay playlists disponibles.");
                return;
            }

            System.out.println("Playlists disponibles:");
            for (int i = 0; i < numPlaylists; i++) {
                System.out.println((i + 1) + ". " + playlists[i].getNombre());
            }

            System.out.print("Seleccione playlist: ");
            int seleccion = sc.nextInt();
            if (seleccion < 1 || seleccion > numPlaylists) {
                System.out.println("Selección inválida.");
                return;
            }

            Playlist playlistSeleccionada = playlists[seleccion - 1];
        }
        biblioteca.mostrarCanciones();  

        System.out.print("Seleccione canción a añadir: ");
       
    }

    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor(); 
        reproductor.mostrarMenuPrincipal(); 
    }
}


