package  Reto004;
public class Cancion {
    private String titulo;
    private String artista;
    private int duracion; // duración en segundos

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String toString() {
        return titulo + " - " + artista + " (" + duracion + "s)";
    }
}