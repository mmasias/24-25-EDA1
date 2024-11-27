class ColaReproduccion {
    private NodoReproduccion frente;
    private NodoReproduccion fin;

    public ColaReproduccion() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Cancion cancion) {
        NodoReproduccion nuevoNodo = new NodoReproduccion(cancion);
        if (fin == null) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }

    public Cancion desencolar() {
        if (frente == null)
            return null;

        Cancion cancion = frente.cancion;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        } else {
            frente.anterior = null;
        }

        return cancion;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        NodoReproduccion actual = frente;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.cancion);
            actual = actual.siguiente;
            indice++;
        }
    }
}