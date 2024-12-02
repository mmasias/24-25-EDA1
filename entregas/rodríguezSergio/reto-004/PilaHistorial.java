class PilaHistorial {
    private Nodo top;

    public void agregarHistorial(Cancion cancion) {
        Nodo nuevoNodo = new Nodo(cancion);
        nuevoNodo.siguiente = top;
        top = nuevoNodo;
    }

    public void mostrarHistorial() {
        Nodo temporal = top;
        while (temporal != null) {
            System.out.println(temporal.cancion);
            temporal = temporal.siguiente;
        }
    }
}