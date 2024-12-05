package Ejercicio001.Reto004;

class Playlist extends Album {

  private String nombre;
  private ListaEnlazada<Cancion> canciones;

  public Playlist(String nombre) {
    super(nombre, "", 0);
    this.nombre = nombre;
    canciones = new ListaEnlazada<>();
  }

  public String getNombre() {
    return nombre;
  }

  public ListaEnlazada<Cancion> getCanciones() {
    return canciones;
}

  public void añadirCancion(Cancion cancion) {
    canciones.agregar(cancion);
  }

  public void eliminarCancion(Cancion cancion) {
    canciones.eliminar();
  }

  public void mostrarCanciones() {
    System.out.println("Playlist: " + nombre);
    canciones.mostrar();
  }

  @Override
  public String toString() {
    return nombre;
  }
}
