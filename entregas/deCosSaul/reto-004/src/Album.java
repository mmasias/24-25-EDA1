class Album {
    private String titulo;
    private String artista;
    private int ano;
    private Lista canciones;
        
    public Album(String titulo, String artista, int ano) {
        this.titulo = titulo;
        this.artista = artista;
        this.ano = ano;
        this.canciones = new Lista();
    }

    public void anadirCancion(Cancion cancion){
        this.canciones.insertEnd(cancion);
    }
    
    public void anadirCancion(String titulo, String artista, int duracion){
        Cancion cancion = new Cancion(titulo, artista, duracion);
        this.canciones.insertEnd(cancion);
    }
    
    public String toString(){
        return titulo + " " + artista + " " + ano + "\n" + canciones.listAll();
    }
    

}