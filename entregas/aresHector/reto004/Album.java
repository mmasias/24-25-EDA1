import java.util.LinkedList;

public class Album {
    private String titulo;
    private String artista;
    private int año;
    private LinkedList<Cancion> canciones;

    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new LinkedList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public LinkedList<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }
}
