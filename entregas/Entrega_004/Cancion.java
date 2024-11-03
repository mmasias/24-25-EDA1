package entregas.Entrega_004;

public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;    
    private boolean favorita;
    private String value;
    private Cancion next;
    
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
    }    

    public String toString(){
        return titulo + " - " + artista + " [" + duracion + "s]";
    }


public String getTitulo() {
    return titulo;
}

public String getArtista() {
    return artista;
}

public int getDuracion() {
    return duracion;
}

public boolean isFavorita() {
    return favorita;
}

public void marcarFavorita() {
    this.favorita = true;
}

public void desmarcarFavorita() {
    this.favorita = false;
}

}