
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

    public void drop() {
        this.first = null;
        this.size = 0;
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
        size++;
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        size++;
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            size--;
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

        Node[] matches = new Node[matchCount];
        iterator = this.first;
        int index = 0;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                matches[index] = iterator;
                index++;
            }
            iterator = iterator.getNext();
        }

        return matches;
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
