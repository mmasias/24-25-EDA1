class ListaPlaylist {
    private NodoPlaylist cabeza;

    public ListaPlaylist() {
        cabeza = null;
    }

    public void agregarPlaylist(Playlist playlist) {
        NodoPlaylist nuevoNodo = new NodoPlaylist(playlist);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoPlaylist actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public Playlist obtenerPlaylist(int indice) {
        NodoPlaylist actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice)
                return actual.playlist;
            contador++;
            actual = actual.siguiente;
        }
        System.out.println("Índice fuera de rango.");
        return null;
    }

    public void mostrar() {
        NodoPlaylist actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.playlist.getNombre());
            actual = actual.siguiente;
            indice++;
        }
    }
}