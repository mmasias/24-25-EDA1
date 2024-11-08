package entregas.nevesKelvia.Reto_004;

class ListaEnlazada<Elemento> {
    private Nodo<Elemento> cabeza;
    private int tamaño;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void añadir(Elemento dato) {
        Nodo<Elemento> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<Elemento> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamaño++;
    }

    public int tamaño() {
        return tamaño;
    }

    public Elemento obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return null;
        }
        Nodo<Elemento> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return;
        }
        if (indice == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo<Elemento> actual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                actual = actual.siguiente;
            }
            actual.siguiente = actual.siguiente.siguiente;
        }
        tamaño--;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void mostrarElementos() {
        Nodo<Elemento> actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.dato);
            actual = actual.siguiente;
            indice++;
        }
    }
}


