public class Lista {
    private int size = 0;
    private Node first = null;

    public int size() {
        return this.size;
    }

    public void insertEnd(Object value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
    }

    public void deleteAll() {
        this.first = null;
    }

    public String listAll() {
        String salida = "";
        Node iterator = this.first;
        int count = 1;
        while (iterator != null) {
            salida += "  " + count + ". " + iterator.getValue().toString() + "\n";
            count++;
            iterator = iterator.getNext();
        }
        return salida;
    }

    public void mostrar() {
        Node iterator = this.first;
        int indice = 0;
        while (iterator != null) {
            System.out.print(indice + ". ");
            iterator.show();
            iterator = iterator.getNext();
            indice++;
        }
    }

    public Node getFirst() {
        return first;
    }

    public void deleteNode(Node nodeToDelete) {
        if (first == null || nodeToDelete == null) return; // Lista vacía o nodo nulo

        // Si el nodo a eliminar es el primero
        if (first == nodeToDelete) {
            first = first.getNext();
            size--;
            return;
        }

        Node current = first;
        while (current != null) {
            if (current.getNext() == nodeToDelete) {
                current.setNext(nodeToDelete.getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }
}