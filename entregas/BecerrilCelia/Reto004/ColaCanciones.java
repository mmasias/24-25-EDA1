package Reto004;

public class ColaCanciones {
    private NodoCancion frente;
    private NodoCancion finalCola;

    public ColaCanciones() {
        this.frente = null;
        this.finalCola = null;
    }

    public void encolar(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (finalCola == null) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    public Cancion desencolar() {
        if (frente == null) return null;
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        }
        return cancion;
    }

    public void mostrarCola() {
        NodoCancion actual = frente;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }
}