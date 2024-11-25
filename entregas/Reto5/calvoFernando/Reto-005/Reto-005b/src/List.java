public class List {
    private Node first = null;
    private int size = 1;

    public int size() {
        return size;
    }

    public Node getFirst() {
        return this.first;
    }
    
    public boolean isEmpty() {
        return this.first == null;
    }

    public void insertEnd(Object value) {
        Node newNode = new Node(value.toString(), size);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }

    public Node obtenerUltimo() {
        if (this.first == null) {
            return null;
        }
        Node iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public boolean incluye(String value) {
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }
}