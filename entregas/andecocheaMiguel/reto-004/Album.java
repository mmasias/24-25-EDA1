class Album<Cancion> {
    private String nombre;
    private String artista;
    private Node canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = null;
    }

    public void agregarCancion(Cancion cancion) {
        Node nuevoNodo = new Node(cancion);
        nuevoNodo.siguiente = canciones; 
        canciones = nuevoNodo;
    }

    public void mostrarCanciones() {
        Node actual = canciones;
        int index = 1;
        while (actual != null) {
            System.out.println(index + ". " + actual.cancion);
            actual = actual.siguiente;
        }
    }

    public int size() {
        int count = 0;
        Node actual = canciones;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }
}
