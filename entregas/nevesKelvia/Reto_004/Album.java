package entregas.nevesKelvia.Reto_004;

class Album {
    private String titulo;
    private String artista;
    private int año;
    
    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }
}