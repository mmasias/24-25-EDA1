package entregas.lopesBrenda.reto004;

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    public ListaEnlazada() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public T get(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }
        Nodo<T> temp = cabeza;
        for (int i = 0; i < index; i++) {
            temp = temp.siguiente;
        }
        return temp.elemento;
    }

    public int size() {
        return tamaño;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public void eliminar(T elemento) {
        if (cabeza == null) return;

        if (cabeza.elemento.equals(elemento)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return;
        }

        Nodo<T> temp = cabeza;
        while (temp.siguiente != null) {
            if (temp.siguiente.elemento.equals(elemento)) {
                temp.siguiente = temp.siguiente.siguiente;
                tamaño--;
                return;
            }
            temp = temp.siguiente;
        }
    }

    public T obtener(int index) {
        return get(index); // Alias para acceder al método get
    }

    public void mostrar() {
        Nodo<T> temp = cabeza;
        while (temp != null) {
            System.out.print(temp.elemento + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    private static class Nodo<T> {
        T elemento;
        Nodo<T> siguiente;

        public Nodo(T elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }
}
