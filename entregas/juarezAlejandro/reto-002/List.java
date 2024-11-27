public class List {

    private Node first = null;
    public int size = 0;

    public int size() {
        return size;
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
            if (this.first.getNext() == null) {
                this.first = null;
            } else {
                Node iterator = this.first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                if (previous != null) {
                    previous.setNext(null);
                }
            }
            size--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            size--;
        }
    }

    public FoundNodeList find(String value) {
        FoundNodeList foundList = new FoundNodeList();
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundList.insert(iterator);
            }
            iterator = iterator.getNext();
        }

        return foundList;
    }

    public void clear() {
        this.first = null;
        this.size = 0;
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        int index = 0;
        while (iterator != null) {
            list[index] = iterator.getValue();
            index++;
            iterator = iterator.getNext();
        }
        return list;
    }
}