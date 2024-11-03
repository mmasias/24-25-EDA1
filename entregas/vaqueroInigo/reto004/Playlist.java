package entregas.vaqueroInigo.reto004;

public class Playlist {
    private ListaDoble canciones = new ListaDoble();
    private String nombre;

    public Playlist(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
    }

    public void mostrar() {
        System.out.println("Playlist: " + nombre);
        canciones.mostrar();
    }
}
