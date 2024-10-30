class Album {
    private String titulo;
    private String artista;
    private int ano;
    private List album = new List();


    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
    }

    public String toString(){
        return titulo;
    }

    public void anadirCancion(Cancion cancion){
        album.insertEnd(cancion);
    }

    public void mostrarAlbum(){
        System.out.println(artista + " - " + titulo + " [" + ano + "]");
        album.mostrar();
    }
}