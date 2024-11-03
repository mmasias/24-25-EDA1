package entregas.Entrega_004;

public class Biblioteca {
    DoubleListSong songs;
    DoubleListSong favorites;
    Playlist playlist;
    PlaylistQueue playlistQueue;

    public Biblioteca() {
        this.songs = new DoubleListSong();
        this.favoritas = new DoubleListSong();
        this.playlist = new Playlist();
        this.playlistQueue = new PlaylistQueue();
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

    public void showSongs() {
        System.out.println("Canciones en la biblioteca:");
        songs.toString();
    }


}
    
    
