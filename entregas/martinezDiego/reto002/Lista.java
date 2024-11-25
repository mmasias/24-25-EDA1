package entregas.martinezDiego.reto002;

class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }


    public void agregar(String data) {
        Nodo nuevoNodo = new Nodo(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = nuevoNodo;
        }
    }

    
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.data + " -> ");
            actual = actual.next;
        }
        System.out.println("null");
    }

    
    public Nodo getCabeza() {
        return cabeza;
    }
}

