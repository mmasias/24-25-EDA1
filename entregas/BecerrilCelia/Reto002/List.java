package Reto002;
public class List {
    private Node first;
    private int size;

    public void deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
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
            this.size--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            this.size--;
        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            n.setNext(this.first);
            this.first = n;
        }
        this.size++;
    }

    public FoundNodeList find(String value) {
        FoundNodeList foundNodes = new FoundNodeList();
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundNodes.addNode(iterator);
            }
            iterator = iterator.getNext();
        }
        return foundNodes;
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        for (int count = 0; iterator != null; count++) {
            list[count] = iterator.getValue();
            iterator = iterator.getNext();
        }
        return list;
    }

    public void clear() {
        this.first = null;
        this.size = 0;
    }
}