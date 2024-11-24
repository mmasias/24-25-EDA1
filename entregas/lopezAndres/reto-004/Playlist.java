class Playlist {
    private Nodo cabeza;
    private String titulo;

    public Playlist(String titulo) {
        this.titulo = titulo;
        this.cabeza = null;
    }

    public void agregarCancion(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void removeCancion(int index) {
        if (cabeza == null) return;

        if (index == 0) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo actual = cabeza;
        for (int i = 0; i < index - 1 && actual.siguiente != null; i++) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public void mostrarCanciones() {
        Nodo actual = cabeza;
        int index = 1;
        while (actual != null) {
            System.out.println(index++ + ". " + actual.cancion);
            actual = actual.siguiente;
        }
    }

    public int size() {
        int count = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    public Cancion getCancion(int index) {
        Nodo actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.cancion;
    }
}
