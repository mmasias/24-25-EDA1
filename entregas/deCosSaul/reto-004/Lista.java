class Lista {
    private String titulo;
    private String artista;
    private int ano;
    private List lista = new List();


    public Lista(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
    }

    public Lista() {
        this.titulo = "Biblioteca";
        this.artista = null;
    }

    public String toString(){
        return titulo;
    }

    public void anadirCancion(Cancion cancion){
        lista.insertEnd(cancion);
    }

    public void anadirCrearCancion(String titulo, String artista, String duracion){
        lista.insertEnd(new Cancion(titulo, artista, ano));

    }

    public void mostrarCanciones(){
        if (ano != 0){
        System.out.println(artista + " - " + titulo + " [" + ano + "]");
        } else {
            System.out.println(titulo);
        }
        lista.mostrar();
    }
}