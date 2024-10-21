package entregas.grizoniManuela.reto002;

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
        return this.size() == 0;
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

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            } else {
                this.first = null; 
            }
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public void clear() {
        this.first = null;
    }

    public FoundNodeList find(String value) {
        FoundNodeList foundNodes = new FoundNodeList();
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundNodes.add(iterator);
            }
            iterator = iterator.getNext();
        }
        return foundNodes;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
