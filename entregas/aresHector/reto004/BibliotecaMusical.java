import java.util.LinkedList;

public class BibliotecaMusical {
    private LinkedList<Cancion> cancionesFavoritas;
    private LinkedList<Album> albums;
    private LinkedList<Playlist> playlists;
    private LinkedList<Cancion> canciones; // Lista de todas las canciones disponibles

    public BibliotecaMusical() {
        this.cancionesFavoritas = new LinkedList<>();
        this.albums = new LinkedList<>();
        this.playlists = new LinkedList<>();
        this.canciones = new LinkedList<>(); // Inicializamos la lista de canciones
    }

    // Método para agregar una canción a la biblioteca
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    // Método para agregar una canción a favoritos
    public void agregarCancionAFavoritos(Cancion cancion) {
        if (!cancionesFavoritas.contains(cancion)) {
            cancionesFavoritas.add(cancion);
            cancion.setFavorita(true);
            System.out.println(cancion.getTitulo() + " añadida a favoritos.");
        } else {
            System.out.println(cancion.getTitulo() + " ya está en favoritos.");
        }
    }

    // Método para eliminar una canción de favoritos
    public void eliminarCancionDeFavoritos(Cancion cancion) {
        if (cancionesFavoritas.remove(cancion)) {
            cancion.setFavorita(false);
            System.out.println(cancion.getTitulo() + " eliminada de favoritos.");
        } else {
            System.out.println(cancion.getTitulo() + " no está en favoritos.");
        }
    }

    // Método para ver las canciones favoritas
    public void verCancionesFavoritas() {
        System.out.println("CANCIONES FAVORITAS:");
        for (Cancion cancion : cancionesFavoritas) {
            System.out.println(cancion);
        }
    }

    // Método para agregar un álbum
    public void agregarAlbum(Album album) {
        albums.add(album);
    }

    // Método para ver todos los álbumes
    public void verAlbums() {
        System.out.println("ÁLBUMES:");
        for (Album album : albums) {
            System.out.println(album);
        }
    }

    // Método para crear una nueva playlist
    public void crearPlaylist(String nombre) {
        Playlist playlist = new Playlist(nombre);
        playlists.add(playlist);
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    // Método para ver todas las playlists
    public void verPlaylists() {
        System.out.println("PLAYLISTS:");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getNombre());
        }
    }

    // Método para ver canciones de una playlist específica
    public void verCancionesPlaylist(String nombrePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNombre().equalsIgnoreCase(nombrePlaylist)) {
                playlist.verCanciones();
                return;
            }
        }
        System.out.println("Playlist no encontrada: " + nombrePlaylist);
    }

    // Método para obtener todas las canciones en la biblioteca
    public LinkedList<Cancion> getTodasLasCanciones() {
        return canciones;
    }
}

