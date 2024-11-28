import java.util.Scanner;

class Biblioteca {

    private Playlist primera = null;

    public int tamañoBiblioteca() {
        if (this.primera == null) {
            return 0;
        }

        int contador = 1;
        Playlist iterador = primera;
        while (iterador.getNext() != null) {
            contador++;
            iterador = (Playlist) iterador.getNext();
        }
        return contador;
    }

    public void crearPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre de la nueva playlist: ");
        String nombre = scanner.nextLine();

        Playlist nuevaPlaylist = new Playlist(nombre);

        if (this.primera == null) {
            this.primera = nuevaPlaylist;
        } else {
            Playlist iterador = this.primera;
            while (iterador.getNext() != null) {
                iterador = (Playlist) iterador.getNext();
            }
            iterador.setNext(nuevaPlaylist);
        }
    }

    public void imprimirBiblioteca() {
        int tamaño = this.tamañoBiblioteca();

        if (tamaño == 0) {
            System.out.println("Todavía no hay playlists en la biblioteca");
            return;
        }

        Playlist iterador = this.primera;
        System.out.println("Playlists:");
        while (iterador != null) {
            System.out.println("- " + iterador.getNombre());
            iterador = (Playlist) iterador.getNext();
        }
    }

    public void añadirCancionPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pon el nombre de la playlist a la que quieres añadir la cancion:");
        String nombre = scanner.nextLine();

        Playlist playlist = buscarPlaylist(nombre);
        if (playlist != null) {
            playlist.añadirCancion();
        } else {
            System.out.println("Playlist no encontrada");
        }
    }

    public void eliminarCancionPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pon el nombre de la playlist a la que quieres eliminar la cancion:");
        String nombre = scanner.nextLine();

        Playlist playlist = buscarPlaylist(nombre);
        if (playlist != null) {
            playlist.eliminarCancion();
        } else {
            System.out.println("Playlist no encontrada");
        }
    }

    public void imprimirPlaylist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la playlist que quiere ver:");
        String nombre = scanner.nextLine();

        Playlist playlist = buscarPlaylist(nombre);
        if (playlist != null) {
            String[] canciones = playlist.length;
            if (canciones.length == 0) {
                System.out.println("La playlist está vacía.");
            } else {
                System.out.println("Canciones en la playlist " + nombre + ":");
                for (String cancion : canciones) {
                    System.out.println("- " + cancion);
                }
            }
        } else {
            System.out.println("Playlist no encontrada");
        }
        playlist.imprimir();
    }

    private Playlist buscarPlaylist(String nombre) {
        Playlist iterador = this.primera;
        while (iterador != null) {
            if (iterador.getNombre().equals(nombre)) {
                return iterador;
            }
            iterador = iterador.getNext();
        }
        return null;
    }

}
