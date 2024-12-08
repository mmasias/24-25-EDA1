
class FoundNodeList {

    private NodeWrapper first = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insertFront(Node node) {
        NodeWrapper n = new NodeWrapper(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        this.size++;
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            this.size--;
        }
    }

    public void deleteAll() {
        this.first = null;
        this.size = 0;
    }

    public Node[] listAll() {
       Node[] list = new Node[this.size()];
        NodeWrapper iterator = this.first;
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
    