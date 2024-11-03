package entregas.grizoniManuela.reto004;

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

    public String getTitulo() {return titulo;}
    public String getArtista() {return artista;}
    public int getDuracion() {return duracion;}
    public boolean isFavorita() {return favorita;}

    public void setFavorita(boolean favorita) {this.favorita = favorita;}

    public String toString(){
        return "Titulo: " +  titulo + ", Artista: " + artista + ", Duracion" + duracion + (favorita ? "Si" : "No");

    }
}

class Album {
    private String titulo;
    private String artista;
    private int año;
    
    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
    }

    public String getTitulo() {return titulo;}
    public String getArtista() {return artista;}
    public int getAño(){return año;}

    public String toString(){
        return "Album: " + titulo + ", Artista: " + artista + ", Año: " + año;
        
    }
}