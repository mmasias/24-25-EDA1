public class Cancion {
    private String titulo;
    private String artista;
    private int duracion;    
    private boolean favorita;
    
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
    }    

    public String toString(){
        return titulo + " " + duracion + "s"; 
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista(){
        return artista;
    }
}