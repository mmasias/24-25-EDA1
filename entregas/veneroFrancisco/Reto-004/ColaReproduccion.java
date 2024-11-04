class ColaReproduccion {
    private NodoCancion cabeza;
    private NodoCancion cola;

    public ColaReproduccion() {
        cabeza = null;
        cola = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public Cancion siguienteCancion() {
        if (cabeza == null) {
            return null;
        }
        Cancion cancion = cabeza.cancion;
        cabeza = cabeza.siguiente;
        if (cabeza == null) {
            cola = null;
        }
        return cancion;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void mostrarCola() {
        if (cabeza == null) {
            System.out.println("No hay canciones en la cola.");
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