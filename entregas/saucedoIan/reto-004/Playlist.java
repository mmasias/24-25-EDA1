public class Playlist {
  private String nombre;
  private ListaDobleCancion canciones;

  public Playlist(String nombre) {
    this.nombre = nombre;
    this.canciones = new ListaDobleCancion();
  }

  public String getNombre() {
    return nombre;
  }

  public ListaDobleCancion getCanciones() {
    return canciones;
  }

  public void añadirCancion(Cancion cancion) {
    canciones.agregar(cancion);
  }

  public void eliminarCancion(Cancion cancion) {
    canciones.eliminar(cancion);
  }

  public void verCanciones() {
    System.out.println("=== Playlist: " + nombre + " ===");
    canciones.imprimirLista();
  }
}