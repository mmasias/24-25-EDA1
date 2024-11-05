public class Biblioteca {
    private ListaEnlazada cancionesFavoritas;
    private ListaEnlazada playlists; 

    public Biblioteca() {
        this.cancionesFavoritas = new ListaEnlazada();
        this.playlists = new ListaEnlazada();
    }

    public void agregarFavorito(Cancion cancion) {
        cancionesFavoritas.insertarAlFinal(cancion);
    }

    public void eliminarFavorito(Cancion cancion) {
        cancionesFavoritas.eliminar(cancion);
    }

    public void mostrarFavoritos() {
        System.out.println("Canciones favoritas:");
        cancionesFavoritas.imprimirLista();
    }

    public void crearPlaylist(String nombre) {
        Playlist nuevaPlaylist = new Playlist(nombre);
        playlists.insertarAlFinal(nuevaPlaylist);
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void mostrarPlaylists() {
        System.out.println("Playlists disponibles:");
        Nodo actual = playlists.cabeza; 
        int index = 1;
        while (actual != null) {
            Playlist playlist = (Playlist) actual.dato; 
            System.out.println(index + ". " + playlist.getNombre());
            actual = actual.siguiente;
            index++;
        }
    }

    public Playlist obtenerPlaylist(int indice) {
        Nodo actual = playlists.cabeza;
        for (int i = 0; i < indice && actual != null; i++) {
            actual = actual.siguiente;
        }
        return (actual != null) ? (Playlist) actual.dato : null; // Retornamos la playlist si existe
    }
}

