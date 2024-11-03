import java.util.Scanner;

class Playlist {

    private String nombre;
    private Playlist next;
    private Cancion primera = null;
    public String[] length;

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

        if (this.primera == null) {
            System.out.println("No hay canciones para eliminar");
            return;
        }

        if (this.primera.getNombre().equals(nombre)) {
            this.primera = this.primera.getNext();
            System.out.println("Cancion eliminada");
            return;
        }

        Cancion iterador = this.primera;
        while (iterador.getNext() != null) {
            if (iterador.getNext().getNombre().equals(nombre)) {
                iterador.setNext(iterador.getNext().getNext());
                System.out.println("Cancion eliminada");
                return;
            }
            iterador = iterador.getNext();
        }
        System.out.println("Cancion no encontrada");
    }

    public void imprimir() {
        int tamaño = this.tamañoPlaylist();

        if (tamaño == 0) {
            System.out.println("Todavía no hay canciones en la playlist");
            return;
        }

        Cancion iterador = this.primera;
        System.out.println("Canciones:");
        while (iterador != null) {
            System.out.println("- " + iterador.getNombre());
            iterador = (Cancion) iterador.getNext();
        }
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
