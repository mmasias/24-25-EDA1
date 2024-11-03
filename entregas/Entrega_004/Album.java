package entregas.Entrega_004;

public class Album {
    public String titulo;
    public String artista;
    public int año;

    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
    }

    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getAño() {
        return año;
    }
}