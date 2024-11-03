import java.util.Scanner;

class MenuReproduccion {

    public void imprimir() {
        System.out.print("""
                === MENÚ REPRODUCCIÓN ===
                1.Añadir cancion a cola
                2. Ver canción actual
                3. Reproducir siguiente
                4. Reproducir anterior
                5. Ver cola de reproducción
                6. Ver historial
                7. Activar/desactivar aleatorio
                8. Activar/desactivar repetición
                9. Volver al menú principal
                """);
    }

    public void seleccionar() {
        Scanner scanner = new Scanner(System.in);
        Cola cola = new Cola();
        Playlist playlistPrueba = new Playlist("Mac de Marco");
        Cancion cancionPrueba = new Cancion("Moonlight on the river", 422);
        int seleccion;

        do {
            System.out.println("Seleccione una opcion: ");
            seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    cola.añadirCancion();
                case 2:
                    cola.getFirst();
                    break;
                case 3:
                    cola.getNext();
                    break;
                case 4:
                    cola.getPrevious();
                    break;
                case 5:
                    cola.imprimir();
                    break;
                case 6:

                    break;
                case 7:
                    playlistPrueba.aleatorio();
                    break;
                case 8:
                    cancionPrueba.aleatorio();
                    break;
                case 9:
                    break;
            }

        } while (seleccion != 9);

    }

}
