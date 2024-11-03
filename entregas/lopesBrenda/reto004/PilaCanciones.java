package entregas.lopesBrenda.reto004;

class PilaCanciones {
    private NodoGenerico<Cancion> tope;

    public void apilar(Cancion cancion) {
        NodoGenerico<Cancion> nuevo = new NodoGenerico<>(cancion);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Cancion desapilar() {
        if (tope == null) return null;
        Cancion cancion = tope.dato;
        tope = tope.siguiente;
        return cancion;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrarHistorial() {
        NodoGenerico<Cancion> actual = tope;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}