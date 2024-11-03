

public class Historial {
    private NodoCancion cabeza;

    public Historial() {
        this.cabeza = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void mostrarHistorial() {
        NodoCancion actual = cabeza;
        System.out.println("HISTORIAL DE REPRODUCCIÓN:");
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }

}
