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

    public void favorita(){
        if(this.favorita = false){
            this.favorita = true;
        } else {
            this.favorita = false;
        }
    }

    public String toString(){
        return artista + " - " + titulo + " [" + duracion + "s]";
    }
}