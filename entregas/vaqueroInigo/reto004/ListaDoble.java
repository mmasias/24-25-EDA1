package entregas.vaqueroInigo.reto004;

public class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregar(Cancion dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    public Cancion get(int index) {
        if (index < 0 || index >= tamaño) return null;
        Nodo actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public int size() {
        return tamaño;
    }

    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
