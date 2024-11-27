class HistorialReproduccion {
    private NodoReproduccion cabeza;

    public HistorialReproduccion() {
        cabeza = null;
    }

    public void agregar(Cancion cancion) {
        NodoReproduccion nuevoNodo = new NodoReproduccion(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoReproduccion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }
    }

    public NodoReproduccion obtenerUltimoNodo() {
        NodoReproduccion actual = cabeza;
        if (actual == null)
            return null;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public void mostrar() {
        NodoReproduccion actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.cancion);
            actual = actual.siguiente;
            indice++;
        }
    }
}
