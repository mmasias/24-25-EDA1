public class Lista {
    private int size = 0;
    private Node first = null;

    public int size() {
        return this.size;
    }

    public void insertEnd(Object value) {  // Cambiado a Object
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
        while (iterator != null) {
            iterator.show();
            iterator = iterator.getNext();
        }
    }

    // Método para obtener el primer nodo (nuevo)
    public Node getFirst() {
        return first;
    }
}