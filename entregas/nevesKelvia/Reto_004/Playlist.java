package entregas.nevesKelvia.Reto_004;

class Playlist {
    private String nombre;
    private ListaEnlazada<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaEnlazada<>();
    }

    public void añadirCancion(Cancion cancion) {
        canciones.añadir(cancion);
        System.out.println("\"" + cancion.toString() + "\" añadida a " + nombre);
    }

    public void mostrarCanciones() {
        System.out.println("Canciones en la playlist \"" + nombre + "\":");
        canciones.mostrarElementos();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
