class Album {
    private String titulo;
    private String artista;
    private int año;
    public Listalink<Cancion> canciones;

    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new Listalink<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void mostrarCanciones() {
        System.out.println("Álbum: " + titulo + " de " + artista);
        canciones.display();
    }



    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + año + ")";
    }
}
