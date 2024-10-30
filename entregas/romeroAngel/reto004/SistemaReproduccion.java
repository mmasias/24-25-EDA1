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

    public SistemaReproduccion(){
        this.canciones = new List();
        this.playlists = new List();
        this.colaReproduccion = new List();
        this.cancionActual = null;
        this.aleatorio = false;
        this.repeticion = false;
    }

    public void mostrarMenuPrincipal(){
        Scanner scanner =  new Scanner(System.in);
        int opcion;

        do{
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Reproducción");
            System.out.println("2. Biblioteca");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción.");
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
}
