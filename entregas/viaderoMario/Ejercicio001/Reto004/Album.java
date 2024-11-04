package Ejercicio001.Reto004;

class Album {
    private String titulo;
    private String artista;
    private int año;
    public ListaEnlazada <Cancion> canciones;
    
    public Album(String titulo, String artista, int año) {
        this.titulo = titulo;
        this.artista = artista;
        this.año = año;
        this.canciones = new ListaEnlazada<>();
    }

    public void añadirCancion(Cancion cancion){
        canciones.agregar(cancion);
    }

    public void mostrarCanciones(){
        System.out.println("Álbum: " + titulo + " de " + artista);
        canciones.mostrar();
    }
    public String toString(){
        return "Álbum: " + titulo + ", Artista: " + artista + ", Año: " + año;
    }
    
}