package Ejercicio001.Reto004;

class Biblioteca {
    public ListaEnlazada<Cancion> cancionesFavoritas;
    public ListaEnlazada<Album> albums;
    private Cancion cancion;
    private Playlist playlist;

    public Biblioteca(){
        cancionesFavoritas = new ListaEnlazada<>();
        albums = new ListaEnlazada<>();
    }

    public void añadirCancionFavorita(Cancion cancion) {
        cancion.marcarComoFavorito(true);
        cancionesFavoritas.agregar(cancion);
    }

    public void eliminarCancionDeFavoritos(Cancion cancion) {
    cancionesFavoritas.eliminar();     
    cancion.marcarComoFavorito(false);
    }

    public void verCancionesFavoritas() {
        System.out.println("Canciones favoritas:");
        cancionesFavoritas.mostrar();
    }

    public void crearPlaylist(Playlist playlist) {
        albums.agregar(playlist);
    }

    public void verPlaylist() {
        System.out.println("Playlists en la biblioteca:");
        albums.mostrar();
    }

    public Playlist buscaPlaylist(String nombre) {
        for (int i = 0; i < albums.getTamaño(); i++) {
            if (playlist.getNombre().equals(nombre)) {
                return playlist;
            }
        }
        return null;
    }

    public Cancion buscarCancion(String titulo, ListaEnlazada<Cancion> lista) {
        for (int i = 0; i < lista.getTamaño(); i++) {
            if (cancion.getNombre().equals(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public void borraPlaylist(String nombre) {
        for (int i = 0; i < albums.getTamaño(); i++) {
            if (playlist.getNombre().equals(nombre)) {
                albums.eliminar();
                return;
            }
        }
    }

    public void añadirAlbum(Album album) {
        albums.agregar(album);
    }

    public void verAlbums() {
        System.out.println("Álbumes en la biblioteca:");
        albums.mostrar();
    }

}