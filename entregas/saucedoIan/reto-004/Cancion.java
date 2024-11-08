class Cancion {
  private String titulo;

  private int duracion;
  private boolean favorita;
  private Album album;

  public Cancion(String titulo, Album album, int duracion) {
    this.titulo = titulo;

    this.duracion = duracion;
    this.favorita = false;
    this.album = album;
  }

  public String getTitulo() {
    return titulo;
  }

  public Album getAlbum() {
    return album;
  }

  public int getDuracion() {
    return duracion;
  }

  public boolean isFavorita() {
    return favorita;
  }

  public void setFavorita(boolean favorita) {
    this.favorita = favorita;
  }

  public String toString() {
    return "Cancion{" +
        "titulo='" + titulo + '\'' +
        ", artista='" + album.getArtista() + '\'' +
        ", duracion=" + duracion +
        ", favorita=" + favorita +
        '}';
  }
}
