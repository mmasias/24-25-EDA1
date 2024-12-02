class Biblioteca {
    private ListaDobleEnlazada favoritos;
    private ListaDobleEnlazada[] playlists;
    private List<Cancion> cancionesDisponibles;

    public Biblioteca(List<Cancion> cancionesDisponibles) {
        this.cancionesDisponibles = cancionesDisponibles;
        this.favoritos = new ListaDobleEnlazada();
        this.playlists = new ListaDobleEnlazada[10];
    }

    public void agregarAFavoritos(Cancion cancion) {
        cancion.marcarFavorita();
        favoritos.agregarCancion(cancion);
        System.out.println("Canción añadida a favoritos: " + cancion);
    }

    public void eliminarDeFavoritos(Cancion cancion) {
        if (favoritos.eliminarCancion(cancion)) {
            cancion.desmarcarFavorita();
            System.out.println("Canción eliminada de favoritos.");
        } else {
            System.out.println("La canción no se encuentra en favoritos.");
        }
    }

    public void mostrarFavoritos() {
        if (favoritos.estaVacia()) {
            System.out.println("No hay canciones en favoritos.");
        } else {
            System.out.println("Canciones en favoritos:");
            favoritos.mostrarCola();
        }
    }

    public void crearPlaylist(int indice) {
        if (playlists[indice] == null) {
            playlists[indice] = new ListaDobleEnlazada();
            System.out.println("Playlist creada con éxito.");
        } else {
            System.out.println("Ya existe una playlist en esa posición.");
        }
    }

    public void agregarAPlaylist(int indice, Cancion cancion) {
        if (playlists[indice] != null) {
            playlists[indice].agregarCancion(cancion);
            System.out.println("Canción añadida a la playlist.");
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    public void eliminarDePlaylist(int indice, Cancion cancion) {
        if (playlists[indice] != null) {
            if (playlists[indice].eliminarCancion(cancion)) {
                System.out.println("Canción eliminada de la playlist.");
            } else {
                System.out.println("La canción no se encuentra en la playlist.");
            }
        } else {
            System.out.println("Playlist no encontrada.");
        }
    }

    public void mostrarPlaylist(int indice) {
        if (playlists[indice] != null && !playlists[indice].estaVacia()) {
            playlists[indice].mostrarCola();
        } else {
            System.out.println("La playlist está vacía o no existe.");
        }
    }

    public List<Cancion> getCancionesDisponibles() {
        return cancionesDisponibles;
    }
}