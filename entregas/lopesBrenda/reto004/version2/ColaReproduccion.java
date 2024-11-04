package entregas.lopesBrenda.reto004.version2;

class ColaReproduccion {
    public NodoCancion frente;
    private NodoCancion fin;

    public ColaReproduccion() {
        this.frente = null;
        this.fin = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (fin != null) {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
        if (frente == null) {
            frente = nuevoNodo;
        }
    }

    public Cancion siguienteCancion() {
        if (frente == null) return null;
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return cancion;
    }

    public boolean estaVacia() {
        return frente == null;
    }
}
