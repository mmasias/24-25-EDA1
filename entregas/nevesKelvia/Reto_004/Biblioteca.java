package entregas.nevesKelvia.Reto_004;

public class Biblioteca {

    private NodoCancion canciones; 
    private NodoPlaylist playlists; 

    public Biblioteca() {
        this.canciones = null;
        this.playlists = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (canciones == null) {
            canciones = nuevoNodo;
        } else {
            NodoCancion actual = canciones;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Canción añadida a la biblioteca: " + cancion);
    }

    public void mostrarCanciones() {
        if (canciones == null) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        System.out.println("Biblioteca de canciones:");
        NodoCancion actual = canciones;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }

    public void crearPlaylist(String nombre) {
        Playlist nuevaPlaylist = new Playlist(nombre);
        NodoPlaylist nuevoNodo = new NodoPlaylist(nuevaPlaylist);
        if (playlists == null) {
            playlists = nuevoNodo;
        } else {
            NodoPlaylist actual = playlists;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void mostrarPlaylists() {
        if (playlists == null) {
            System.out.println("No hay playlists en la biblioteca.");
            return;
        }

        System.out.println("Playlists:");
        NodoPlaylist actual = playlists;
        while (actual != null) {
            System.out.println(actual.playlist.getNombre());
            actual = actual.siguiente;
        }
    }

}
