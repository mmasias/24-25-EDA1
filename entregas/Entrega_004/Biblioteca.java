package entregas.Entrega_004;

public class Biblioteca {
    private DoubleListSong songs;
    private DoubleListSong favorites;
    private Playlist playlist;
    private PlaylistQueue playlistQueue;

    public Biblioteca() {
        this.songs = new DoubleListSong();
        this.playlist = new Playlist("Mi playlist");
        this.playlistQueue = new PlaylistQueue;
        cargarCanciones();
    }
    

    public void cargarCanciones() {
        songs.inserEnd(new Song("Mil Maneras de Morir", "3AM", 175));
        songs.inserEnd(new Song("Esclava-Remix", "Bryant Myers", 442));
        songs.inserEnd(new Song("Diles", "Bad Bunny", 411));
        songs.inserEnd(new Song("Loba", "Shakira", 309));
        songs.inserEnd(new Song("Vuela", "3AM", 318));
        songs.inserEnd(new Song("Yo lo soñe?", "Saiko", 175));
        songs.inserEnd(new Song("Cangrinaje", "Cruz cafune", 212));
        songs.inserEnd(new Song("Do I Wanna Know?", "Arctic Monkeys", 432));
    }


    public void agregarFavorito(Song song) {
        if (!song.isFavorita()) {
            song.marcarFavorita();
            System.out.println("Añadido a favoritos: " + song);
        } else {
            System.out.println("La canción ya está en favoritos.");
        }
    }

    public void verFavoritos() {
        System.out.println("Canciones favoritas:");
        Song iterator = songs.getFirst(); 
        while (iterator != null) {
            if (iterator.isFavorita()) { 
                System.out.println(iterator); 
            }
            iterator = iterator.getNext(); 
        }

        public void eliminarFavorito(Song song) {
            if (song.isFavorita()) { 
                song.desmarcarFavorita(); 
                System.out.println("Eliminado de favoritos: " + song);
            } else {
                System.out.println("La canción no está en favoritos.");
            }
        }
        
        public void agregarCancionACola(Song song) {
            playlistQueue.encolar(song);
            System.out.println("Añadida a la cola de reproducción: " + song);
        }

        public void crearPlaylist(String nombre) {
            Playlist nuevaPlaylist = new Playlist(nombre);
        } 

    public void verPlaylists() {
        System.out.println("Playlists disponibles:");
        playlist.showSongs();
    }
    
    public void agregarCancionAPlaylist(Playlist playlist, Song song) {
        playlist.inserEnd(song);
        System.out.println("Añadida a la playlist \"" + playlist.getNombre() + "\": " + song);
    }
    
    public void eliminarCancionDePlaylist(Playlist playlist, Song song) {
        playlist.deleteEnd(song);
        System.out.println("Eliminada de la playlist \"" + playlist.getNombre() + "\": " + song);
    }
    
    public void verCancionesDePlaylist(Playlist playlist) {
        System.out.println("Canciones en la playlist \"" + playlist.getNombre() + "\":");
        playlist.showSongs();
    }
    
    
}
    
    
