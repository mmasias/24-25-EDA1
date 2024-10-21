package entregas.martinezDiego.reto002;

class FoundNodeList {
    private Nodo cabeza;

    public FoundNodeList() {
        this.cabeza = null;
    }

    
    public void agregarEncontrado(String data) {
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

    
    public static FoundNodeList find(Lista lista, String value) {
        FoundNodeList encontrados = new FoundNodeList();
        Nodo actual = lista.getCabeza();

        while (actual != null) {
            if (actual.data.equals(value)) {  
                encontrados.agregarEncontrado(actual.data);  
            }
            actual = actual.next;
        }

        return encontrados;
    }
}
