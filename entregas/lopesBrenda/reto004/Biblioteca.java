package entregas.lopesBrenda.reto004;

class Biblioteca {
    private ListaEnlazada<Cancion> cancionesDisponibles;
    private ListaEnlazada<Cancion> cancionesFavoritas;
    private ListaEnlazada<Playlist> playlists;

    public Biblioteca() {
        cancionesDisponibles = new ListaEnlazada<>();
        cancionesFavoritas = new ListaEnlazada<>();
        playlists = new ListaEnlazada<>();
    }

    public void agregarCancion(Cancion cancion) {
        cancionesDisponibles.agregar(cancion);
    }

    public void marcarComoFavorita(Cancion cancion) {
        if (!cancion.esFavorita()) { 
            cancion.marcarFavorita();
            cancionesFavoritas.agregar(cancion);
            System.out.println(cancion.getTitulo() + " se ha añadido a favoritos.");
        }
    }

    public void desmarcarFavorita(Cancion cancion) {
        if (cancion.esFavorita()) { 
            cancion.desmarcarFavorita();
            cancionesFavoritas.eliminar(cancion);
            System.out.println(cancion.getTitulo() + " se ha eliminado de favoritos.");
        }
    }

    public void crearPlaylist(String nombre) {
        Playlist nuevaPlaylist = new Playlist(nombre);
        playlists.agregar(nuevaPlaylist);
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void añadirCancionAPlaylist(String nombrePlaylist, Cancion cancion) {
        Playlist playlist = buscarPlaylist(nombrePlaylist);
        if (playlist != null) {
            playlist.agregarCancion(cancion);
            System.out.println("Canción \"" + cancion.getTitulo() + "\" añadida a la playlist \"" + nombrePlaylist + "\".");
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    public void eliminarCancionDePlaylist(String nombrePlaylist, Cancion cancion) {
        Playlist playlist = buscarPlaylist(nombrePlaylist);
        if (playlist != null) {
            playlist.eliminarCancion(cancion);
            System.out.println("Canción \"" + cancion.getTitulo() + "\" eliminada de la playlist \"" + nombrePlaylist + "\".");
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    public Playlist buscarPlaylist(String nombre) {
        NodoGenerico<Playlist> actual = playlists.getCabeza();
        while (actual != null) {
            if (actual.dato.getNombre().equals(nombre)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrarCancionesDisponibles() {
        System.out.println("Canciones disponibles en la biblioteca:");
        cancionesDisponibles.mostrar();
    }

    public void mostrarCancionesFavoritas() {
        System.out.println("Canciones favoritas:");
        cancionesFavoritas.mostrar();
    }

    public void mostrarPlaylists() {
        System.out.println("Playlists:");
        playlists.mostrar();
    }

    public void mostrarCancionesDePlaylist(String nombrePlaylist) {
        Playlist playlist = buscarPlaylist(nombrePlaylist);
        if (playlist != null) {
            playlist.mostrarCanciones();
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    public ListaEnlazada<Cancion> getCancionesDisponibles() {
        return cancionesDisponibles;
    }

    public ListaEnlazada<Cancion> getCancionesFavoritas() {
        return cancionesFavoritas;
    }

    public ListaEnlazada<Playlist> getPlaylists() {
        return playlists;
    }
}

