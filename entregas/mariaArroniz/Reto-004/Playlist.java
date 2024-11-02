import java.util.Scanner;

class Playlist {

    private String nombre;
    private Playlist next;
    private Cancion primera = null;

    public Playlist(String nombre) {
        this.setNombre(nombre);
    }

    public int tamañoPlaylist() {

        if (this.primera == null) {
            return 0;
        }
        int contador = 1;
        Cancion iterador = primera;
        while (iterador.getNext() != null) {
            contador++;
            iterador = (Cancion) iterador.getNext();
        }
        return contador;
    }

    public void añadirCancion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qué canción quiere añadir: ");
        String nombre = scanner.nextLine();
        System.out.println("Cuánto dura la canción: ");
        int duracion = scanner.nextInt();

        Cancion cancion = new Cancion(nombre, duracion);
        this.primera = cancion;

        if (this.primera == null) {
            this.primera = cancion;
        } else {
            Cancion iterador = this.primera;
            while (iterador.getNext() != null) {
                iterador = (Cancion) iterador.getNext();
            }
            iterador.setNext(cancion);
        }

    }

    public void eliminarCancion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qué canción quiere eliminar: ");
        String nombre = scanner.nextLine();

        Cancion iterador = this.primera;
        if (iterador == null) {
            System.out.println("No hay canciones para eliminar");
        } else if (iterador.getNombre() == nombre) {
            iterador = null;
        } else {
            iterador.getNext();
        }

    }

    public String[] imprimir() {
        String[] playlist = new String[this.tamañoPlaylist()];
        Cancion iterador = this.primera;

        if (tamañoPlaylist() == 0) {
            System.out.println("Todavía no hay canciones en la playlist");
        }
        int contador = 0;
        while (iterador != null) {
            playlist[contador] = iterador.getNombre();
            contador++;
            iterador = (Cancion) iterador.getNext();
        }
        return playlist;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public Playlist getNext() {
        return next;
    }

    public void setNext(Playlist next) {
        this.next = next;
    }

}
