package Reto004;


    
public class Playlist {
    private String nombre;
    private ListaCanciones canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaCanciones();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregarCancion(cancion);
    }

    public void eliminarCancion(String titulo) {
        canciones.eliminarCancion(titulo);
    }

    public void mostrarCanciones() {
        canciones.mostrarCanciones();
    }

    public Cancion obtenerCancion(int index) {
        return canciones.obtenerCancion(index);
    }

    public String toString() {
        return "Playlist: " + nombre;
    }
}
