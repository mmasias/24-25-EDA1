public class Usuario {
  private String nombre;
  private NodoDoble cancionesFavoritas;
  private NodoPlaylist playlists;

  public Usuario(String nombre) {
    this.nombre = nombre;
    this.cancionesFavoritas = null;
    this.playlists = null;
  }

  public String getNombre() {
    return nombre;
  }

  public NodoDoble getCancionesFavoritas() {
    return cancionesFavoritas;
  }

  public NodoPlaylist getPlaylists() {
    return playlists;
  }

  public void añadirCancionAFavoritos(Cancion cancion) {
    NodoDoble nuevoNodo = new NodoDoble(cancion);
    nuevoNodo.siguiente = cancionesFavoritas;
    if (cancionesFavoritas != null) {
      cancionesFavoritas.anterior = nuevoNodo;
    }
    cancionesFavoritas = nuevoNodo;
    cancion.setFavorita(true);
  }

  public void verCancionesFavoritas() {
    System.out.println("=== Canciones Favoritas de " + nombre + " ===");
    NodoDoble actual = cancionesFavoritas;
    while (actual != null) {
      System.out.println(actual.cancion);
      actual = actual.siguiente;
    }
  }

  public void añadirPlaylist(Playlist playlist) {
    NodoPlaylist nuevoNodo = new NodoPlaylist(playlist);
    nuevoNodo.siguiente = playlists;
    playlists = nuevoNodo;
  }

  public void verPlaylists() {
    System.out.println("=== Playlists de " + nombre + " ===");
    NodoPlaylist actual = playlists;
    while (actual != null) {
      System.out.println(actual.playlist.getNombre());
      actual = actual.siguiente;
    }
  }

  public void verCancionesDePlaylist(String nombrePlaylist) {
    NodoPlaylist actual = playlists;
    while (actual != null) {
      if (actual.playlist.getNombre().equals(nombrePlaylist)) {
        actual.playlist.verCanciones();
        return;
      }
      actual = actual.siguiente;
    }
    System.out.println("Playlist no encontrada: " + nombrePlaylist);
  }
}