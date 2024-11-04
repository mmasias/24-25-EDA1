class Cancion {
    private String titulo;
    private String artista;
    private int duracion;
    private boolean favorita;
    private boolean reproducida;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
        this.reproducida = false;

    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }



    public void setReproducida(boolean reproducida) {
        this.reproducida = reproducida;
    }


    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracion + "s)";
    }

    public String getTitulo() {
        return titulo;
    }
}