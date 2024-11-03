package entregas.lopesBrenda.reto004;


class ListaEnlazada<T> {
    private NodoGenerico<T> cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void agregarAlFinal(T dato) {
        NodoGenerico<T> nuevoNodo = new NodoGenerico<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoGenerico<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminar(T dato) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return;
        }

        NodoGenerico<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public void mostrarLista() {
        NodoGenerico<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
