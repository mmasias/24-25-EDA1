package entregas.lopesBrenda.reto004;

class ColaReproduccion {
    private Nodo frente;
    private Nodo fondo;

    private class Nodo {
        Cancion cancion;
        Nodo siguiente;

        Nodo(Cancion cancion) {
            this.cancion = cancion;
            this.siguiente = null;
        }
    }

    public ColaReproduccion() {
        this.frente = null;
        this.fondo = null;
    }

    public void encolar(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (estaVacia()) {
            frente = fondo = nuevoNodo;
        } else {
            fondo.siguiente = nuevoNodo;
            fondo = nuevoNodo;
        }
    }

    public Cancion desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) fondo = null;
        return cancion;
    }

    public Cancion verFrente() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return frente.cancion;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }
        
        Nodo actual = frente;
        int posicion = 1;
        
        while (actual != null) {
            System.out.println(posicion + ". " + actual.cancion);
            actual = actual.siguiente;
            posicion++;
        }
    }
}

