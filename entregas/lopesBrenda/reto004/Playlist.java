package entregas.lopesBrenda.reto004;

public class Playlist {
    private String nombre;
    private ListaEnlazada<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaEnlazada<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.eliminar(cancion);
    }

    public ListaEnlazada<Cancion> getCanciones() {
        return canciones;
    }

    public boolean estaVacia() {
        return canciones.isEmpty();
    }

    public void mostrarCanciones() {
        if (estaVacia()) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }

        System.out.println("Canciones en la playlist \"" + nombre + "\":");
        for (int i = 0; i < canciones.size(); i++) {
            Cancion cancion = canciones.obtener(i);
            System.out.println((i + 1) + ". " + cancion);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
