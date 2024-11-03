package entregas.lopesBrenda.reto004;

public class ColaReproduccion {
    private Nodo frente;
    private Nodo fin;

    public ColaReproduccion() {
        frente = fin = null;
    }

    public void encolar(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        if (fin == null) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Cancion desencolar() {
        if (frente == null) return null;
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return cancion;
    }

    public Cancion verFrente() {
        return frente != null ? frente.cancion : null;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
}
