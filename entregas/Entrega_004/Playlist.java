package entregas.Entrega_004;

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

    public void mostrarCanciones() {
        System.out.println("Playlist: " + nombre);
        canciones.mostrarLista();
    }

    public int getNumeroCanciones() {
        return canciones.getSize();
    }

    public Cancion obtenerCancion(int index) {
        return canciones.obtenerCancion(index);
    }
}