class ListaCanciones {
    private NodoCancion cabeza;

    public ListaCanciones() {
        cabeza = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCancion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminarCancion(Cancion cancion) {
        if (cabeza == null)
            return;

        if (cabeza.cancion.equals(cancion)) {
            cabeza = cabeza.siguiente;
        } else {
            NodoCancion actual = cabeza;
            while (actual.siguiente != null && !actual.siguiente.cancion.equals(cancion)) {
                actual = actual.siguiente;
            }
            if (actual.siguiente != null) {
                actual.siguiente = actual.siguiente.siguiente;
            }
        }
    }

    public boolean contiene(Cancion cancion) {
        NodoCancion actual = cabeza;
        while (actual != null) {
            if (actual.cancion.equals(cancion))
                return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public Cancion obtenerCancion(int indice) {
        NodoCancion actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == indice)
                return actual.cancion;
            contador++;
            actual = actual.siguiente;
        }
        System.out.println("Índice fuera de rango.");
        return null;
    }

    public void mostrar() {
        NodoCancion actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.cancion);
            actual = actual.siguiente;
            indice++;
        }
    }
}