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

    public void insertEnd(Song newSong) {
        songs.inserEnd(newSong);
    }

    public DoubleListSong getSongs(){
        return songs;
    }

    public void deleteEnd() {
        songs.deleteEnd();
    }

   
}
