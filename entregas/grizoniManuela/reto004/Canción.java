package entregas.grizoniManuela.reto004;

class Cancion {
    private String titulo;
    private Album album;  // Nuevo atributo: cada canción pertenece a un álbum
    private int duracion;  // En segundos
    private boolean favorita;

    public Cancion(String titulo, Album album, int duracion) {
        this.titulo = titulo;
        this.album = album;
        this.duracion = duracion;
        this.favorita = false;
    }

    public String getTitulo() { return titulo; }
    public Album getAlbum() { return album; }
    public int getDuracion() { return duracion; }
    public boolean isFavorita() { return favorita; }

    public void setFavorita(boolean favorita) { this.favorita = favorita; }

    @Override
    public String toString() {
        return titulo + " - " + album.getArtista() + " (" + duracion + "s)";
    }
}



class Album {
    private String nombre;
    private String artista;
    private int año;

    public Album(String nombre, String artista, int año) {
        this.nombre = nombre;
        this.artista = artista;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return nombre + " - " + artista + " (" + año + ")";
    }
}