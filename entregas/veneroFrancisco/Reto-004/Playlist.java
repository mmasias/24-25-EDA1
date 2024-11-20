class Playlist {
    private String nombre;
    private NodoCancion cabeza;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void mostrarCanciones() {
        if (cabeza == null) {
            System.out.println("No hay canciones en la playlist.");
            return;
        }
        NodoCancion actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.cancion);
            actual = actual.siguiente;
            i++;
        }
    }
}