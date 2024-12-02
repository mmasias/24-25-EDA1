class ListaEnlazada<T> {
    Nodo<T> cabeza;

    public void agregar(T dato) {
        if (cabeza == null) {
            cabeza = new Nodo<>(dato);
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = new Nodo<>(dato);
        }
    }

    public void eliminar(T dato) {
        if (cabeza == null) return;

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public boolean contiene(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public T obtener(int indice) {
        Nodo<T> actual = cabeza;
        int contador = 0;

        while (actual != null) {
            if (contador == indice) {
                return actual.dato;
            }
            actual = actual.siguiente;
            contador++;
        }

        return null;
    }
}