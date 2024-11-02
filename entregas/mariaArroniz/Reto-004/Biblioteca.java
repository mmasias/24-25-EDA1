import java.util.Scanner;

class Biblioteca {

    private Playlist playlist;
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

        this.playlist = new Playlist(nombre);
        this.primera = playlist;

        if (this.primera == null) {
            this.primera = playlist;
        } else {
            Playlist iterador = this.primera;
            while (iterador.getNext() != null) {
                iterador = (Playlist) iterador.getNext();
            }
            iterador.setNext(playlist);
        }
    }

    public String[] imprimirBiblioteca() {
        String[] biblioteca = new String[this.tamañoBiblioteca()];
        Playlist iterador = this.primera;
        
        if (tamañoBiblioteca() == 0) {
            System.out.println("Todavía no hay playlists en la biblioteca");
        }
        int contador = 0;
        while (iterador != null) {
            biblioteca[contador] = iterador.getNombre();
            contador++;
            iterador = (Playlist) iterador.getNext();
        }
        return biblioteca;
    }
    
    public void añadirCancionPlaylist() {
        playlist.añadirCancion();
    }

    public void eliminarCancionPlaylist() {
        playlist.eliminarCancion();
    }

    public void imprimirPlaylist() {
        playlist.imprimir();
    }

}
