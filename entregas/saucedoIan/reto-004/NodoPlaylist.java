public class NodoPlaylist {
  Playlist playlist;
  NodoPlaylist siguiente;

  public NodoPlaylist(Playlist playlist) {
    this.playlist = playlist;
    this.siguiente = null;
  }
}