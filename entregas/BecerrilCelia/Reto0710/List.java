package Reto0710;

public class List {

    private Node first = null;
    private int size = 0;

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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
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
        this.size++;

    }

        public void deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
                // Only one element in the list
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
            // Decrease the size of the list
            this.size--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();

            this.size--;
        }
    }

    public Node[] find(String value) {

        int count = 0;
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                count++;
            }
            iterator = iterator.getNext();
        }

        Node[] matchingNodes = new Node[count];

        iterator = this.first;
        int index = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                matchingNodes[index++] = iterator;
            }
            iterator = iterator.getNext();
        }

        return matchingNodes;
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
