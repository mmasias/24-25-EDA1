package entregas.lopesBrenda.reto004.version1;

class NodoGenerico<T> {
    T dato;
    NodoGenerico<T> siguiente;

    public NodoGenerico(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}