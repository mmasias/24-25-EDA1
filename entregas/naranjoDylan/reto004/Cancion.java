package entregas.naranjoDylan.reto004;

public class Cancion {
    String titulo;
    String artista;
    int duracion;
    boolean favorita;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " [" + duracion + "s]";
    }
}