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

  public String toString() {
    return "Cancion{" +
        "titulo='" + titulo + '\'' +
        ", artista='" + artista + '\'' +
        ", duracion=" + duracion +
        ", favorita=" + favorita +
        '}';
  }
}
