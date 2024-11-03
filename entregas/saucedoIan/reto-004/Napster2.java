import java.util.Scanner;

public class Napster2 {
  public static void main(String[] args) {
    Sistema sistema = new Sistema("Juan");
    inicializarCanciones(sistema);

    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
      System.out.println("=== MENÚ PRINCIPAL ===");
      System.out.println("1. Reproducción");
      System.out.println("2. Biblioteca");
      System.out.println("3. Salir");
      System.out.print("Seleccione una opción: ");
      opcion = scanner.nextInt();
      scanner.nextLine();
      switch (opcion) {
        case 1:

          int opcionReproduccion;
          do {
            System.out.println("=== MENÚ REPRODUCCIÓN ===");
            System.out.println("1. Ver canción actual");
            System.out.println("2. Reproducir siguiente");
            System.out.println("3. Activar/desactivar aleatorio");
            System.out.println("4. Activar/desactivar repetición");
            System.out.println("5. Ver historial");
            System.out.println("6. Reproducir favoritos");
            System.out.println("7. Reproducir playlist");
            System.out.println("8. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionReproduccion = scanner.nextInt();
            scanner.nextLine();

            switch (opcionReproduccion) {
              case 1:
                sistema.verCancionActual();
                break;
              case 2:
                sistema.reproducirSiguiente();
                break;
              case 3:
                sistema.activarAleatorio();
                break;
              case 4:
                sistema.activarRepeticion();
                break;
              case 5:
                sistema.verHistorial();
                break;
              case 6:
                sistema.reproducirFavoritos();
                break;
              case 7:
                System.out.print("Ingrese el nombre de la playlist: ");
                String nombrePlaylist = scanner.nextLine();
                sistema.reproducirPlaylist(nombrePlaylist);
                break;
            }
          } while (opcionReproduccion != 8);
          break;

        case 2:

          int opcionBiblioteca;
          do {
            System.out.println("=== MENÚ BIBLIOTECA ===");
            System.out.println("1. Añadir canción a favoritos");
            System.out.println("2. Ver canciones favoritas");
            System.out.println("3. Ver playlists");
            System.out.println("4. Ver canciones de una playlist");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcionBiblioteca = scanner.nextInt();
            scanner.nextLine();2

            switch (opcionBiblioteca) {
              case 1:
                System.out.print("Ingrese el nombre de la canción para añadir a favoritos: ");
                String nombreCancion = scanner.nextLine();
                Cancion cancionFavorita = sistema.buscarCancion(nombreCancion);
                if (cancionFavorita != null) {
                  sistema.añadirCancionAFavoritos(cancionFavorita);
                  System.out.println("Canción añadida a favoritos.");
                } else {
                  System.out.println("Canción no encontrada.");
                }
                break;

              case 2:
                sistema.verCancionesFavoritas();
                break;

              case 3:
                sistema.verPlaylists();
                break;

              case 4:
                System.out.print("Ingrese el nombre de la playlist: ");
                String nombrePlaylist = scanner.nextLine();
                sistema.verCancionesDePlaylist(nombrePlaylist);
                break;
            }
          } while (opcionBiblioteca != 5);
          break;
      }
    } while (opcion != 3);

    System.out.println("Gracias por usar el sistema.");
    scanner.close();
  }

  private static void inicializarCanciones(Sistema sistema) {
    Album album1 = new Album("Rock Argentino Vol. 1", "Charly García", 1984);
    Album album2 = new Album("Rock Argentino Vol. 2", "Sui Generis", 1972);
    Album album3 = new Album("Grandes Éxitos", "Serú Girán", 1980);
    Album album4 = new Album("Inolvidables", "Luis Alberto Spinetta", 1986);

    sistema.añadirCancion(new Cancion("Demoliendo Hoteles", album1, 258));
    sistema.añadirCancion(new Cancion("Los Dinosaurios", album1, 234));
    sistema.añadirCancion(new Cancion("No Soy Un Extraño", album1, 295));
    sistema.añadirCancion(new Cancion("Promesas Sobre El Bidet", album1, 243));
    sistema.añadirCancion(new Cancion("Rezo Por Vos", album1, 266));
    sistema.añadirCancion(new Cancion("Película sordomuda", album1, 235));
    sistema.añadirCancion(new Cancion("Yendo de la Cama al Living", album1, 240));
    sistema.añadirCancion(new Cancion("Cerca de la Revolución", album1, 320));

    sistema.añadirCancion(new Cancion("Rasguña Las Piedras", album2, 285));
    sistema.añadirCancion(new Cancion("Canción Para Mi Muerte", album2, 342));
    sistema.añadirCancion(new Cancion("Bienvenidos al Tren", album2, 260));
    sistema.añadirCancion(new Cancion("Confesiones de Invierno", album2, 315));
    sistema.añadirCancion(new Cancion("Aprendizaje", album2, 270));
    sistema.añadirCancion(new Cancion("Necesito", album2, 250));
    sistema.añadirCancion(new Cancion("Cuando Ya Me Empiece a Quedar Solo", album2, 300));
    sistema.añadirCancion(new Cancion("Quizás, Porque", album2, 245));

    sistema.añadirCancion(new Cancion("Seminare", album3, 238));
    sistema.añadirCancion(new Cancion("Viernes 3AM", album3, 276));
    sistema.añadirCancion(new Cancion("A Los Jóvenes de Ayer", album3, 310));
    sistema.añadirCancion(new Cancion("Peperina", album3, 252));
    sistema.añadirCancion(new Cancion("La Grasa de las Capitales", album3, 328));
    sistema.añadirCancion(new Cancion("No Llores por Mí, Argentina", album3, 290));
    sistema.añadirCancion(new Cancion("Esperando Nacer", album3, 289));
    sistema.añadirCancion(new Cancion("Eiti Leda", album3, 308));

    sistema.añadirCancion(new Cancion("Bajan", album4, 235));
    sistema.añadirCancion(new Cancion("Muchacha (Ojos de Papel)", album4, 260));
    sistema.añadirCancion(new Cancion("Barro Tal Vez", album4, 270));
    sistema.añadirCancion(new Cancion("Todas Las Hojas Son del Viento", album4, 220));
    sistema.añadirCancion(new Cancion("Durazno Sangrando", album4, 265));
    sistema.añadirCancion(new Cancion("Cementerio Club", album4, 275));

    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Demoliendo Hoteles"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Los Dinosaurios"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Seminare"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Rasguña Las Piedras"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Bajan"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Muchacha (Ojos de Papel)"));
    sistema.añadirCancionAFavoritos(sistema.buscarCancion("Canción Para Mi Muerte"));

    Playlist playlist1 = new Playlist("1");
    playlist1.añadirCancion(sistema.buscarCancion("Demoliendo Hoteles"));
    playlist1.añadirCancion(sistema.buscarCancion("Los Dinosaurios"));
    playlist1.añadirCancion(sistema.buscarCancion("No Soy Un Extraño"));
    playlist1.añadirCancion(sistema.buscarCancion("Promesas Sobre El Bidet"));
    playlist1.añadirCancion(sistema.buscarCancion("Yendo de la Cama al Living"));
    sistema.añadirPlaylist(playlist1);

    Playlist playlist2 = new Playlist("2");
    playlist2.añadirCancion(sistema.buscarCancion("Rasguña Las Piedras"));
    playlist2.añadirCancion(sistema.buscarCancion("Seminare"));
    playlist2.añadirCancion(sistema.buscarCancion("Viernes 3AM"));
    playlist2.añadirCancion(sistema.buscarCancion("Muchacha (Ojos de Papel)"));
    playlist2.añadirCancion(sistema.buscarCancion("La Grasa de las Capitales"));
    playlist2.añadirCancion(sistema.buscarCancion("Todas Las Hojas Son del Viento"));
    sistema.añadirPlaylist(playlist2);
  }
}