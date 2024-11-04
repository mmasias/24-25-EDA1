class Playlist {
    private String nombre;
    private ListaEnlazada<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaEnlazada<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.agregar(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.eliminar(cancion);
    }

    public void verCanciones() {
        System.out.println("Canciones en la playlist \"" + nombre + "\":");
        canciones.mostrar();
    }

    public Cancion obtenerCancion(int indice) {
        return canciones.obtener(indice);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}

