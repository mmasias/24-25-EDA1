class Album {
    private String nombre;
    private String artista;
    private Nodo canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = null;
    }

    public void agregarCancion(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        nuevoNodo.siguiente = canciones; 
        canciones = nuevoNodo;
    }

    public void mostrarCanciones() {
        Nodo actual = canciones;
        int index = 1;
        while (actual != null) {
            System.out.println(index++ + ". " + actual.cancion);
            actual = actual.siguiente;
        }
    }

    public int size() {
        int count = 0;
        Nodo actual = canciones;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }
}
