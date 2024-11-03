package entregas.Entrega_004;

public class PlaylistNode {
    private Playlist playlist;
    private PlaylistNode siguiente;
    private PlaylistNode anterior;
    private DoubleListSong songs;

    public PlaylistNode(Playlist playlist) {
        this.playlist = playlist;
        this.siguiente = null;
        this.anterior = null;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public PlaylistNode getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(PlaylistNode siguiente) {
        this.siguiente = siguiente;
    }

    public PlaylistNode getAnterior() {
        return anterior;
    }

    public void setAnterior(PlaylistNode anterior) {
        this.anterior = anterior;
    }

    public void insertEnd(Song newSong){
        songs.insertEnd(newSong);
    }
}
