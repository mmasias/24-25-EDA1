class Cancion {
    private String titulo;
    private String artista;
    private int id;
    private static int counter = 0;
    private int duracion;    
    private boolean favorita;
    
    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
        this.id = getId();
    }    
        
    private int getId() {
        counter++;
        return counter;
    }
        
    public void favorita(){
        if(this.favorita == false){
            this.favorita = true;
        } else {
            this.favorita = false;
        }
    }

    public void enFavoritos(){
        System.out.println(this.favorita == true ? "Si" : "No");
    }

    public String toString(){
        return id + ". " + artista + " - " + titulo + " [" + duracion + "s]";
    }
}