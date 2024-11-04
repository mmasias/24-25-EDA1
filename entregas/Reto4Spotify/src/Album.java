class Album {

    private String titulo;
    private String artista;
    private int año;

    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
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

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }
}



