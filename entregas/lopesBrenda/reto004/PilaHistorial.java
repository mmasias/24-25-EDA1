package entregas.lopesBrenda.reto004;

class PilaHistorial {
    private NodoHistorial cima;

    private class NodoHistorial {
        Cancion cancion;
        NodoHistorial siguiente;

        NodoHistorial(Cancion cancion) {
            this.cancion = cancion;
            this.siguiente = null;
        }
    }

    public void apilar(Cancion cancion) {
        NodoHistorial nuevoNodo = new NodoHistorial(cancion);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public Cancion desapilar() {
        if (cima == null) return null;
        Cancion cancion = cima.cancion;
        cima = cima.siguiente;
        return cancion;
    }

    public Cancion verCima() {
        return cima != null ? cima.cancion : null;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
