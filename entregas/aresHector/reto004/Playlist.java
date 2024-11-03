import java.util.LinkedList;

public class Playlist {
    private String nombre;
    private LinkedList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println(cancion.getTitulo() + " añadida a " + nombre);
    }

    public void eliminarCancion(Cancion cancion) {
        if (canciones.remove(cancion)) {
            System.out.println(cancion.getTitulo() + " eliminada de " + nombre);
        } else {
            System.out.println(cancion.getTitulo() + " no está en la playlist " + nombre);
        }
    }

    public void verCanciones() {
        System.out.println("Canciones en " + nombre + ":");
        for (Cancion cancion : canciones) {
            System.out.println(cancion);
        }
    }
}
