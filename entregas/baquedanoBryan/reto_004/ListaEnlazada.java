public class ListaEnlazada {
    private Nodo cabeza;
    private Nodo cola;

    public ListaEnlazada() {
        this.cabeza = null;
        this.cola = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarAlFinal(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public void eliminar(Cancion cancion) {
        if (estaVacia()) return;

        // Si la cabeza es la canción a eliminar
        if (cabeza.dato.equals(cancion)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null; // Si la lista queda vacía, también actualizamos cola
            }
            return;
        }

        // Buscamos el nodo anterior al que queremos eliminar
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(cancion)) {
                actual.siguiente = actual.siguiente.siguiente;
                if (actual.siguiente == null) {
                    cola = actual; // Actualizamos cola si eliminamos el último nodo
                }
                return;
            }
            actual = actual.siguiente;
        }
    }
}
