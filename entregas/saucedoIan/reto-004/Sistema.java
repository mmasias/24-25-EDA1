public class Sistema {
  private ListaDobleCancion listaCanciones = new ListaDobleCancion();
  private PilaCancion historial = new PilaCancion();
  private boolean aleatorio = false;
  private boolean repeticion = false;
  private Usuario usuario;

  public Sistema(String nombreUsuario) {
    this.usuario = new Usuario(nombreUsuario);
  }

  public void añadirCancion(Cancion cancion) {
    listaCanciones.agregar(cancion);
  }

  public void verCancionActual() {
    Cancion cancionActual = listaCanciones.obtenerSiguiente();
    if (cancionActual != null) {
      System.out.println("Reproduciendo: " + cancionActual.getTitulo() + " - " + cancionActual.getAlbum().getArtista());
      historial.push(cancionActual);
    } else {
      System.out.println("No hay canciones en la lista.");
    }
  }

  public void reproducirSiguiente() {
    Cancion siguienteCancion;
    if (aleatorio) {
      siguienteCancion = listaCanciones.obtenerCancionAleatoria();
    } else {
      siguienteCancion = listaCanciones.obtenerSiguiente();
    }

    if (siguienteCancion != null) {
      System.out
          .println("Reproduciendo: " + siguienteCancion.getTitulo() + " - " + siguienteCancion.getAlbum().getArtista());
      historial.push(siguienteCancion);
    }
  }

  public void activarAleatorio() {
    aleatorio = !aleatorio;
    System.out.println("Modo aleatorio: " + (aleatorio ? "Activado" : "Desactivado"));
  }

  public void activarRepeticion() {
    repeticion = !repeticion;
    System.out.println("Modo repetición: " + (repeticion ? "Activado" : "Desactivado"));
  }

  public void verHistorial() {
    System.out.println("=== Historial de reproducción ===");
    historial.imprimirPila();
  }

  public void añadirCancionAFavoritos(Cancion cancion) {
    usuario.añadirCancionAFavoritos(cancion);
  }

  public void eliminarCancionDeFavoritos(Cancion cancion) {
    usuario.eliminarCancionDeFavoritos(cancion);
  }

  public void verCancionesFavoritas() {
    usuario.verCancionesFavoritas();
  }

  public void añadirPlaylist(Playlist playlist) {
    usuario.añadirPlaylist(playlist);
  }

  public void eliminarCancionDePlaylist(String nombrePlaylist, Cancion cancion) {
    usuario.eliminarCancionDePlaylist(nombrePlaylist, cancion);
  }

  public void verPlaylists() {
    usuario.verPlaylists();
  }

  public void verCancionesDePlaylist(String nombrePlaylist) {
    usuario.verCancionesDePlaylist(nombrePlaylist);
  }

  public Cancion buscarCancion(String titulo) {
    NodoDoble actual = listaCanciones.cabeza;
    if (actual != null) {
      do {
        if (actual.cancion.getTitulo().equalsIgnoreCase(titulo)) {
          return actual.cancion;
        }
        actual = actual.siguiente;
      } while (actual != listaCanciones.cabeza);
    }
    return null;
  }

  public void reproducirFavoritos() {
    System.out.println("=== Reproduciendo Canciones Favoritas ===");
    NodoDoble actual = usuario.getCancionesFavoritas();
    while (actual != null) {
      System.out
          .println("Reproduciendo: " + actual.cancion.getTitulo() + " - " + actual.cancion.getAlbum().getArtista());
      historial.push(actual.cancion);
      actual = actual.siguiente;
    }
  }

  public void reproducirPlaylist(String nombrePlaylist) {
    NodoPlaylist actual = usuario.getPlaylists();
    while (actual != null) {
      if (actual.playlist.getNombre().equalsIgnoreCase(nombrePlaylist)) {
        System.out.println("=== Reproduciendo Playlist: " + nombrePlaylist + " ===");
        actual.playlist.verCanciones();
        NodoDoble nodoCancion = actual.playlist.getCanciones().cabeza;
        if (nodoCancion != null) {
          do {
            System.out.println("Reproduciendo: " + nodoCancion.cancion.getTitulo() + " - "
                + nodoCancion.cancion.getAlbum().getArtista());
            historial.push(nodoCancion.cancion);
            nodoCancion = nodoCancion.siguiente;
          } while (nodoCancion != actual.playlist.getCanciones().cabeza);
        }
        return;
      }
      actual = actual.siguiente;
    }
    System.out.println("Playlist no encontrada: " + nombrePlaylist);
  }
}