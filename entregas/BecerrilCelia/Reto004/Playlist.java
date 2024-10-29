package Reto004;



public class Playlist {
    private String nombre;
    private ListaCircularCanciones canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaCircularCanciones();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregarCancion(cancion);
    }

    public void eliminarCancion(String titulo) {
        canciones.eliminar(titulo);
    }

    public void mostrarCanciones() {
        canciones.mostrarCanciones();
    }

    public Cancion obtenerCancion(int index) {
        return canciones.obtenerCancionActual();
    }

    public String toString() {
        return "Playlist: " + nombre;
    }
}
