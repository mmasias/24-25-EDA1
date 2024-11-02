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


    public void mostrarCancionesDisponibles() {
        Album album1 = new Album("The Dark Side of the Moon", "Pink Floyd", 1973);
        Album album2 = new Album("Abbey Road", "The Beatles", 1969);
        Album album3 = new Album("The Wall", "Pink Floyd", 1979);
        Album album4 = new Album("Led Zeppelin IV", "Led Zeppelin", 1971);
        Album album5 = new Album("Revolver", "The Beatles", 1966);
        Album album6 = new Album("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", 1967);
        Album album7 = new Album("The White Album", "The Beatles", 1968);
        Album album8 = new Album("A Night at the Opera", "Queen", 1975);

        album1.añadirCancion(new Cancion("Speak to Me", "Pink Floyd", 90));
        album1.añadirCancion(new Cancion("Breathe", "Pink Floyd", 163));
        album2.añadirCancion(new Cancion("Come Together", "The Beatles", 259));
        album2.añadirCancion(new Cancion("Something", "The Beatles", 182));
        album3.añadirCancion(new Cancion("In the Flesh?", "Pink Floyd", 193));
        album3.añadirCancion(new Cancion("The Thin Ice", "Pink Floyd", 140));
        album4.añadirCancion(new Cancion("Black Dog", "Led Zeppelin", 296));
        album4.añadirCancion(new Cancion("Rock and Roll", "Led Zeppelin", 223));
        album5.añadirCancion(new Cancion("Eleanor Rigby", "The Beatles", 138));
        album5.añadirCancion(new Cancion("Yellow Submarine", "The Beatles", 158));
        album6.añadirCancion(new Cancion("Lucy in the Sky with Diamonds", "The Beatles", 208));
        album6.añadirCancion(new Cancion("A Day in the Life", "The Beatles", 337));
        album7.añadirCancion(new Cancion("Back in the U.S.S.R.", "The Beatles", 163));
        album7.añadirCancion(new Cancion("While My Guitar Gently Weeps", "The Beatles", 285));
        album8.añadirCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        album8.añadirCancion(new Cancion("You're My Best Friend", "Queen", 172));
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