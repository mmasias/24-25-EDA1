package entregas.Entrega_004;

public class Playlist {

    private String nombre;
    private DoubleListSong songs;

    public Playlist(String nombre){
        this.nombre = nombre;
        this.songs = new DoubleListSong();
    }

    public int size() {
        return songs.size();
    }

    public void insertEnd(String titulo, String artista, int duracion, String value) {
        Song newSong = new Song(titulo, artista, duracion, value);
        songs.inserEnd(newSong);
    }

    public DoubleListSong getSongs(){
        return songs;
    }

    public void deleteEnd() {
        songs.deleteEnd();
    }

   
}
