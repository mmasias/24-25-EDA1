package entregas.nevesKelvia.Reto_004;

class Biblioteca {
    private ListaEnlazada<Cancion> canciones;
    private ListaEnlazada<Cancion> favoritas;
    private ListaEnlazada<Playlist> playlists;

    public Biblioteca() {
        canciones = new ListaEnlazada<>();
        favoritas = new ListaEnlazada<>();
        playlists = new ListaEnlazada<>();
    }

    public void añadirCancion(Cancion cancion) {
        canciones.añadir(cancion);
    }

    public void añadirAFavoritos(Cancion cancion) {
        cancion.marcarComoFavorita();
        favoritas.añadir(cancion);
    }

    public void eliminarDeFavoritos(Cancion cancion) {
        cancion.desmarcarComoFavorita();
        for (int i = 0; i < favoritas.tamaño(); i++) {
            if (favoritas.obtener(i).equals(cancion)) {
                favoritas.eliminar(i);
                break;
            }
        }
    }

    public void mostrarCanciones() {
        System.out.println("Canciones disponibles en la biblioteca:");
        canciones.mostrarElementos();
    }

    public void mostrarFavoritas() {
        System.out.println("Canciones favoritas:");
        favoritas.mostrarElementos();
    }

    public void crearPlaylist(String nombre) {
        playlists.añadir(new Playlist(nombre));
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public ListaEnlazada<Cancion> getCanciones() {
        return canciones;
    }
    
    public ListaEnlazada<Cancion> getCancionesFavoritas() {
        return favoritas;
    }
    

    public ListaEnlazada<Playlist> obtenerPlaylists() {
        return playlists;
    }
}
