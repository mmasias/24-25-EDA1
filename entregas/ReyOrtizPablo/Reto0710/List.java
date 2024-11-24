package entregas.ReyOrtizPablo.Reto0710;

public class List {
    private Node first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
        this.size++;
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

    public Node[] find(String value) {
        Node iterator = this.first;
        int matchCount = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                matchCount++;
            }
            iterator = iterator.getNext();
        }

        if (matchCount == 0) {
            return null;
        }

        Node[] result = new Node[matchCount];
        iterator = this.first;
        int index = 0;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                result[index] = iterator;
                index++;
            }
            iterator = iterator.getNext();
        }

        return result;
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public void clearList() {
        this.first = null;
        this.size = 0;
    }
}
