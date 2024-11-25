class Cola<T> {
    Nodo<T> frente;
    Nodo<T> fin;

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (fin != null) {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = fin;
        }
    }

    public T desencolar() {
        if (frente == null) return null;
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
