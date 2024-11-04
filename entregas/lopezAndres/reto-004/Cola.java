class Cola {
    private Nodo frente;
    private Nodo finalCola;

    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    public void agregar(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (finalCola == null) { 
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    public Cancion siguiente() {
        if (frente == null) return null; 
        Cancion cancionActual = frente.cancion;
        frente = frente.siguiente; 
        return cancionActual;
    }

    public void mostrarCola() {
        Nodo actual = frente;
        int index = 1;
        while (actual != null) {
            System.out.println(index++ + ". " + actual.cancion);
            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int size() {
        int count = 0;
        Nodo actual = frente;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    public Nodo getFrente() {
        return frente;
    }
}
