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

    public String toString(){
        return artista;

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

    public String toString(){
        return artista;
        
    }
}