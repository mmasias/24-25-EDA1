package Ejercicio001.Reto004;

class Cancion {
    private String nombre;
    private String artista;
    private int duracion;    
    private boolean favorita;
    private boolean reproducida;

    public Cancion(String nombre, String artista, int duracion) {
        this.nombre = nombre;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
        this.reproducida = false;
    }    

    public String getNombre(){
     return nombre;
    }
    public void marcarComoFavorito(boolean favorita){
        this.favorita = favorita;
    }

    public void marcarComoReproducida(boolean reproducida){
        this.reproducida = reproducida;
    }

    public String toString(){
        return nombre + " - " + artista + " (" + duracion + ")";
    }
}

