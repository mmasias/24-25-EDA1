class FoundNodeList {

    private Node first;
    private int size = 0;
    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size > 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null){
            this.first = newNode;
        }else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node iterator = this.first;
        while (iterator != null) {
            stringBuilder.append(iterator.getValue());
            if (iterator.getNext() != null) {
                stringBuilder.append(", ");
            }
            iterator = iterator.getNext();
        }
        return stringBuilder.toString();
    }
}