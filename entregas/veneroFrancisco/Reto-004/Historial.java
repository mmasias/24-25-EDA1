class Historial {
    private NodoCancion cabeza;

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void mostrarHistorial() {
        if (cabeza == null) {
            System.out.println("No hay historial de reproducción.");
            return;
        }
        NodoCancion actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.cancion);
            actual = actual.siguiente;
            i++;
        }
    }
}