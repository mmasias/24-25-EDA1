package entregas.lopesBrenda.reto004;

import java.util.LinkedList;

public class Playlist {
    private String nombre;
    private LinkedList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new LinkedList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.remove(cancion);
    }

    public LinkedList<Cancion> getCanciones() {
        return canciones;
    }

    public String getNombre() {
        return nombre;
    }
}
