package entregas.naranjoDylan.reto004;

public class Playlist {
    String nombre;
    Lista canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new Lista();
    }
}