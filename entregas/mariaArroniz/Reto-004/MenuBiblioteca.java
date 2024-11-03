import java.util.Scanner;

class MenuBiblioteca {

    public void imprimir() {
        System.out.print("""
                === MENÚ BIBLIOTECA ===
                1. Añadir canción a favoritos
                2. Eliminar canción de favoritos
                3. Ver canciones favoritas
                4. Crear nueva playlist
                5. Añadir canción a playlist
                6. Eliminar canción de playlist
                7. Ver playlists
                8. Ver canciones de una playlist
                9. Volver al menú principal
                """);
    }

    public void seleccionar() {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        Favoritos favoritos = new Favoritos();
        int seleccion;

        do {
            System.out.println("Seleccione una opcion: ");
            seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    favoritos.añadirCancion();
                    break;
                case 2:
                    favoritos.eliminarCancion();
                    break;
                case 3:
                    favoritos.imprimir();
                    break;
                case 4:
                    biblioteca.crearPlaylist();
                    break;
                case 5:
                    biblioteca.añadirCancionPlaylist();
                    break;
                case 6:
                    biblioteca.eliminarCancionPlaylist();
                    break;
                case 7:
                    biblioteca.imprimirBiblioteca();
                    break;
                case 8:
                    biblioteca.imprimirPlaylist();
                    break;
                case 9:
                    break;
            }
        } while (seleccion != 9);
    }
}
