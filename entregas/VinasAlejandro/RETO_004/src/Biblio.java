class Biblio {
    public Listalink<Cancion> cancionesFavoritas;
    private Listalink<Album> albums;
    private Cancion cancion;
    private Playlist playlist;

    public Biblio() {
        cancionesFavoritas = new Listalink<>();
        albums = new Listalink<>();
    }

    public void añadirCancionFavorita(Cancion cancion) {
        cancion.setFavorita(true);
        cancionesFavoritas.add(cancion);
    }

    public void eliminarCancionFavorita(Cancion cancion) {
        cancionesFavoritas.remove();
        cancion.setFavorita(false);
    }

    public void verFavoritas() {
        System.out.println("Canciones favoritas:");
        cancionesFavoritas.display();
    }


    public void añadirAlbum(Album album) {
        albums.add(album);
    }

    public void crearPlaylist(Playlist playlist) {
        albums.add(playlist);
    }

    public Playlist buscaPlaylist(String nombre) {
        for (int i = 0; i < albums.getSize(); i++) {
            if (playlist.getNombre().equals(nombre)) {
                return playlist;
            }
        }
        return null;

    }

    public void verAlbums() {
        System.out.println("Álbumes en la biblioteca:");
        albums.display();
    }

    public void verPlaylist() {
        System.out.println("Playlists en la biblioteca:");
        albums.display();
    }

    public Cancion buscarCancion(String titulo, Listalink<Cancion> lista) {
        for (int i = 0; i < lista.getSize(); i++) {
            if (cancion.getTitulo().equals(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public void borraPlaylist(String nombre) {
        for (int i = 0; i < albums.getSize(); i++) {
            if (playlist.getNombre().equals(nombre)) {
                albums.remove();
                return;
            }
        }
    }

    public void iniciarpredeterminados() {
        Album album1 = new Album("The Dark Side of the Moon", "Pink Floyd", 1973);
        Album album2 = new Album("Abbey Road", "The Beatles", 1969);
        Album album3 = new Album("The Wall", "Pink Floyd", 1979);
        Album album4 = new Album("Led Zeppelin IV", "Led Zeppelin", 1971);
        Album album5 = new Album("Revolver", "The Beatles", 1966);
        Album album6 = new Album("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", 1967);
        Album album7 = new Album("The White Album", "The Beatles", 1968);
        Album album8 = new Album("A Night at the Opera", "Queen", 1975);

        album1.agregarCancion(new Cancion("Speak to Me", "Pink Floyd", 90));
        album1.agregarCancion(new Cancion("Breathe", "Pink Floyd", 163));
        album2.agregarCancion(new Cancion("Come Together", "The Beatles", 259));
        album2.agregarCancion(new Cancion("Something", "The Beatles", 182));
        album3.agregarCancion(new Cancion("In the Flesh?", "Pink Floyd", 193));
        album3.agregarCancion(new Cancion("The Thin Ice", "Pink Floyd", 140));
        album4.agregarCancion(new Cancion("Black Dog", "Led Zeppelin", 296));
        album4.agregarCancion(new Cancion("Rock and Roll", "Led Zeppelin", 223));
        album5.agregarCancion(new Cancion("Eleanor Rigby", "The Beatles", 138));
        album5.agregarCancion(new Cancion("Yellow Submarine", "The Beatles", 158));
        album6.agregarCancion(new Cancion("Lucy in the Sky with Diamonds", "The Beatles", 208));
        album6.agregarCancion(new Cancion("A Day in the Life", "The Beatles", 337));
        album7.agregarCancion(new Cancion("Back in the U.S.S.R.", "The Beatles", 163));
        album7.agregarCancion(new Cancion("While My Guitar Gently Weeps", "The Beatles", 285));
        album8.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        album8.agregarCancion(new Cancion("You're My Best Friend", "Queen", 172));
    }
}