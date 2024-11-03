package entregas.vaqueroInigo.reto004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReproductorMusical reproductor = new ReproductorMusical();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar canción a biblioteca");
            System.out.println("2. Mostrar biblioteca");
            System.out.println("3. Agregar canción a favoritos");
            System.out.println("4. Mostrar canciones favoritas");
            System.out.println("5. Reproducir siguiente canción");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese título de la canción:");
                    String titulo = scanner.nextLine();
                    System.out.println("Ingrese artista:");
                    String artista = scanner.nextLine();
                    System.out.println("Ingrese duración en segundos:");
                    int duracion = scanner.nextInt();
                    reproductor.agregarCancionABiblioteca(new Cancion(titulo, artista, duracion));
                    break;
                case 2:
                    reproductor.mostrarBiblioteca();
                    break;
                case 5:
                    reproductor.reproducirSiguiente();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
