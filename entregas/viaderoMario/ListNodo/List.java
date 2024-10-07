package ListNodo;

public class List {

    Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
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
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
                // Solo hay un nodo
                this.first = null;
            } else {
                Node iterator = this.first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null);
            }
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext(); // Elimina el primer nodo
        }
    }

    public Node[] find(String value) {
        Node iterator = this.first;
        int count = 0;

       
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                count++;
            }
            iterator = iterator.getNext();
        }

        
        Node[] result = new Node[count];
        iterator = this.first; 

        
        int index = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                result[index++] = iterator;
            }
            iterator = iterator.getNext();
        }

        return result;
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
}