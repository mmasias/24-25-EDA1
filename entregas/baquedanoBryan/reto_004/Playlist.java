class Playlist {
    private String nombre;
    private ListaEnlazada canciones; // Lista enlazada para almacenar las canciones en la playlist

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaEnlazada(); // Inicializamos la lista de canciones
    }

    public void agregarCancion(Cancion cancion) {
        canciones.insertarAlFinal(cancion); // Agregamos la canción a la lista
    }

    public void eliminarCancion(Cancion cancion) {
        canciones.eliminar(cancion); // Eliminamos la canción de la lista
    }

    public void mostrarCanciones() {
        System.out.println("Canciones en la playlist " + nombre + ":");
        canciones.imprimirLista(); // Imprimimos las canciones en la playlist
    }

    @Override
    public String toString() {
        return nombre; 
    }
}
