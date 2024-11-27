class NodoReproduccion {
    Cancion cancion;
    NodoReproduccion siguiente;
    NodoReproduccion anterior;

    public NodoReproduccion(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
        this.anterior = null;
    }
}
