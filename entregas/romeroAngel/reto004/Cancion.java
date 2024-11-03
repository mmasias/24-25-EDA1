package romeroAngel.reto004;

class Cancion {
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

    public void marcarComoFavorita(){
        this.favorita = true;
    }

    public void desmarcarComoFavorita(){
        this.favorita = false;
    }

    public boolean esFavorita(){
        return favorita;
    }

    public String toString(){
        return titulo + " - " + artista + " [" + duracion + "]s";
    }

    public String getArtista() {
        return artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

}