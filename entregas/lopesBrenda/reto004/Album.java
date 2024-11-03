package entregas.lopesBrenda.reto004;
import java.util.LinkedList;

class Album {
    private String titulo;
    private String artista;
    private int año;
    private LinkedList<Cancion> canciones;
    
    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
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

    public String toString(){}
}