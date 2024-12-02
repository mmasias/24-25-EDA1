class Biblioteca {
    ListaEnlazada<Cancion> canciones;
    ListaEnlazada<Cancion> favoritas;
    ListaEnlazada<Playlist> playlists;
    Album album;

    public Biblioteca() {
        this.canciones = new ListaEnlazada<>();
        this.favoritas = new ListaEnlazada<>();
        this.playlists = new ListaEnlazada<>();
        this.album = new Album("Meteora", "Linkin Park", 2003);
        cargarCancionesDelAlbum();
    }

    private void cargarCancionesDelAlbum() {
        canciones.agregar(new Cancion("Foreword", album.getArtista(), 13));
        canciones.agregar(new Cancion("Don't Stay", album.getArtista(), 184));
        canciones.agregar(new Cancion("Somewhere I Belong", album.getArtista(), 217));
        canciones.agregar(new Cancion("Lying from You", album.getArtista(), 174));
        canciones.agregar(new Cancion("Hit the Floor", album.getArtista(), 163));
        canciones.agregar(new Cancion("Easier to Run", album.getArtista(), 209));
        canciones.agregar(new Cancion("Faint", album.getArtista(), 162));
        canciones.agregar(new Cancion("Figure.09", album.getArtista(), 197));
        canciones.agregar(new Cancion("Breaking the Habit", album.getArtista(), 197));
        canciones.agregar(new Cancion("From the Inside", album.getArtista(), 165));
        canciones.agregar(new Cancion("Nobody's Listening", album.getArtista(), 162));
        canciones.agregar(new Cancion("Session", album.getArtista(), 139));
        canciones.agregar(new Cancion("Numb", album.getArtista(), 185));
    }

    public void mostrarCanciones() {
        System.out.println("Canciones del álbum " + album + ":");
        canciones.mostrar();
    }

    public void agregarFavorito(Cancion cancion) {
        if (!favoritas.contiene(cancion)) {
            favoritas.agregar(cancion);
            cancion.marcarFavorita();
            System.out.println("Añadido a favoritos: " + cancion);
        } else {
            System.out.println("La canción ya está en favoritos.");
        }
    }

    public void eliminarFavorito(Cancion cancion) {
        if (favoritas.contiene(cancion)) {
            favoritas.eliminar(cancion);
            cancion.desmarcarFavorita();
            System.out.println("Eliminado de favoritos: " + cancion);
        } else {
            System.out.println("La canción no está en favoritos.");
        }
    }

    public void verFavoritos() {
        System.out.println("Canciones favoritas:");
        if (favoritas.estaVacia()) {
            System.out.println("No tienes canciones favoritas.");
        } else {
            favoritas.mostrar();
        }
    }

    public void crearPlaylist(String nombre) {
        playlists.agregar(new Playlist(nombre));
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void verPlaylists() {
        if (playlists.estaVacia()) {
            System.out.println("No hay playlists creadas.");
        } else {
            System.out.println("Playlists disponibles:");
            playlists.mostrar();
        }
    }

    public void agregarCancionAPlaylist(Playlist playlist, Cancion cancion) {
        playlist.agregarCancion(cancion);
        System.out.println("Añadida a la playlist \"" + playlist.getNombre() + "\": " + cancion);
    }

    public void eliminarCancionDePlaylist(Playlist playlist, Cancion cancion) {
        playlist.eliminarCancion(cancion);
        System.out.println("Eliminada de la playlist \"" + playlist.getNombre() + "\": " + cancion);
    }

    public void verCancionesDePlaylist(Playlist playlist) {
        System.out.println("Canciones en la playlist \"" + playlist.getNombre() + "\":");
        playlist.verCanciones();
    }
}
