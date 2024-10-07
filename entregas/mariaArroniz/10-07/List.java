class List {

    private Node first = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
            size++;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
            size++;
        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
            size++;
        } else {
            n.setNext(this.first);
            this.first = n;
            size++;
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
            previous.setNext(null);
            size--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            first = first.getNext();
            size--;
        }
    }

    public void deleteEverything() {
        if (this.first != null) {
            first = null;
        }
    }

    public Node[] find(String value) {
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