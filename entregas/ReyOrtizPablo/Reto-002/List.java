public class List {

    private Node first = null;

    public int size() {
        int count = 0;
        Node iterator = first;
        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insertEnd(String value) {
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
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void deleteEnd() {
        if (this.first == null) return;

        if (this.first.getNext() == null) {
            this.first = null;
            return;
        }

        Node iterator = this.first;
        Node previous = null;
        while (iterator.getNext() != null) {
            previous = iterator;
            iterator = iterator.getNext();
        }
        previous.setNext(null);
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    // Aquí es donde añades el nuevo método find:
    public Node[] find(String value) {
        // Creamos un arreglo temporal con un tamaño igual al número de elementos en la lista.
        Node[] results = new Node[size()];
        Node iterator = this.first;
        int index = 0;

        // Recorremos la lista
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                results[index] = iterator; // Guardamos el nodo si el valor coincide
                index++;
            }
            iterator = iterator.getNext(); // Avanzamos al siguiente nodo
        }

        // Creamos un arreglo final que contendrá únicamente los nodos encontrados
        Node[] finalResults = new Node[index];
        System.arraycopy(results, 0, finalResults, 0, index);

        return finalResults; // Retornamos el arreglo con los nodos encontrados
    }
}
    }
}
