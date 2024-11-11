package Reto004;

public class ListaCanciones {
    private NodoCancion cabeza;

    public ListaCanciones() {
        this.cabeza = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCancion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminarCancion(String titulo) {
        if (cabeza == null) return;
        if (cabeza.cancion.getTitulo().equals(titulo)) {
            cabeza = cabeza.siguiente;
            return;
        }
        NodoCancion actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.cancion.getTitulo().equals(titulo)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public void mostrarCanciones() {
        NodoCancion actual = cabeza;
        int index = 1;
        while (actual != null) {
            System.out.println(index + ". " + actual.cancion);
            actual = actual.siguiente;
            index++;
        }
    }

    public Cancion obtenerCancion(int index) {
        NodoCancion actual = cabeza;
        int contador = 1;
        while (actual != null) {
            if (contador == index) {
                return actual.cancion;
            }
            actual = actual.siguiente;
            contador++;
        }
        return null;
    }
}
