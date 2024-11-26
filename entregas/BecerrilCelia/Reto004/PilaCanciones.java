package Reto004;


public class PilaCanciones {
    private NodoCancion cima;

    public PilaCanciones() {
        this.cima = null;
    }

    public void apilar(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public Cancion desapilar() {
        if (cima == null) return null;
        Cancion cancion = cima.cancion;
        cima = cima.siguiente;
        return cancion;
    }

    public void mostrarPila() {
        NodoCancion actual = cima;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return cima == null;
    }
}