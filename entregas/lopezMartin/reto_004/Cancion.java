package entregas.lopezMartin.reto_004;

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

    public Cancion(Cancion cancion) {
        this.titulo = cancion.titulo;
        this.artista = cancion.artista;
        this.duracion = cancion.duracion;
        this.favorita = cancion.favorita;
    }

    public String toString(){

        return this.titulo + " - " + this.artista + " (" + this.duracion + "s)";

    }

    public void setFavorita(){
        this.favorita = true;
    }

    public void unsetFavorita(){
        this.favorita = false;
    }

    public boolean esFavorita(){
        return this.favorita;
    }
    
}
