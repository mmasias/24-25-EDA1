package entregas.naranjoDylan.reto004;

public class Lista {
    Nodo cabeza;
    Nodo cola;

    public void agregar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public void eliminar(Object dato) {
        if (cabeza == null)
            return;
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            if (cabeza == null)
                cola = null;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente == null)
                cola = actual;
        }
    }

    public void mostrar() {
        Nodo actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.dato);
            actual = actual.siguiente;
            i++;
        }
    }
}