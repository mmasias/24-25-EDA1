package Ejercicio001.Reto004;

import java.util.Random;

class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public T eliminar() {
        if (cabeza == null) return null;
        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza == null) cola = null;
        return dato;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamaño() {
        int tamaño = 0;
        Nodo<T> current = cabeza;
        while (current != null) {
            tamaño++;
            current = current.siguiente;
        }
        return tamaño;
    }

        public T getRandom(Random random) {
        if (estaVacia()) return null;
        int size = getTamaño();
        int randomIndex = random.nextInt(size);
        Nodo<T> current = cabeza;
        for (int i = 0; i < randomIndex; i++) {
            current = current.siguiente;
        }
        return current.dato;
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    public Cancion get(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}