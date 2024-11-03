package entregas.lopesBrenda.reto004;

class Playlist {
    private String nombre;
    private ListaEnlazada<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaEnlazada<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregarAlFinal(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.eliminar(cancion);
    }

    public void mostrarCanciones() {
        System.out.println("Playlist: " + nombre);
        canciones.mostrarLista();
    }

    public String getNombre() {
        return nombre;
    }
}
