package Reto004;

public class ListaPlaylists {
    private NodoPlaylist cabeza;

    public ListaPlaylists() {
        this.cabeza = null;
    }

    public void agregarPlaylist(Playlist playlist) {
        NodoPlaylist nuevoNodo = new NodoPlaylist(playlist);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoPlaylist actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public Playlist buscarPlaylist(String nombre) {
        NodoPlaylist actual = cabeza;
        while (actual != null) {
            if (actual.playlist.getNombre().equals(nombre)) {
                return actual.playlist;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarPlaylists() {
        NodoPlaylist actual = cabeza;
        int index = 1;
        while (actual != null) {
            System.out.println(index + ". " + actual.playlist);
            actual = actual.siguiente;
            index++;
        }
    }

    public Playlist obtenerPlaylist(int index) {
        NodoPlaylist actual = cabeza;
        int contador = 1;
        while (actual != null) {
            if (contador == index) {
                return actual.playlist;
            }
            actual = actual.siguiente;
            contador++;
        }
        return null;
    }
}