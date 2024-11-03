package reto004;

public class ColaReproduccion {
    private NodoCancion inicio, fin;

    public ColaReproduccion() {
        inicio = fin = null;
    }

    public void encolar(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (fin == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public Cancion desencolar() {
        if (inicio == null) return null;

        Cancion cancion = inicio.cancion;
        inicio = inicio.siguiente;
        if (inicio == null) fin = null;
        return cancion;
    }

    public void mostrarCola() {
        NodoCancion actual = inicio;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }
}
