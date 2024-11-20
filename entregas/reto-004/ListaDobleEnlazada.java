class ListaDobleEnlazada {
    private Nodo inicio, fin;
    private Nodo actual;

    public ListaDobleEnlazada() {
        inicio = fin = null;
    }

    public void agregarCancion(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (inicio == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
        if (actual == null) {
            actual = inicio;
        }
    }

    public boolean eliminarCancion(Cancion cancion) {
        Nodo temporal = inicio;
        while (temporal != null) {
            if (temporal.cancion == cancion) {
                if (temporal.anterior != null) temporal.anterior.siguiente = temporal.siguiente;
                if (temporal.siguiente != null) temporal.siguiente.anterior = temporal.anterior;
                if (temporal == inicio) inicio = temporal.siguiente;
                if (temporal == fin) fin = temporal.anterior;
                return true;
            }
            temporal = temporal.siguiente;
        }
        return false;
    }

    public Cancion siguiente() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual != null ? actual.cancion : null;
    }

    public Cancion anterior() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        }
        return actual != null ? actual.cancion : null;
    }

    public Cancion verActual() {
        return actual != null ? actual.cancion : null;
    }

    public void mostrarCola() {
        Nodo temporal = inicio;
        while (temporal != null) {
            System.out.println(temporal.cancion);
            temporal = temporal.siguiente;
        }
    }
    public boolean estaVacia() {
        return inicio == null;
    }
}