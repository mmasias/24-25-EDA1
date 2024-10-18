public class List {

    private NodeWrapper first = null;
    private int size = 0;

    public boolean isEmpty() {
        return this.size > 0;
    }

    public int getSize(){
        return size;
    }

    public void insertEnd(Node node) {
        NodeWrapper newNodeWrapper = new NodeWrapper(node);
        if (this.first == null)
            this.first = newNodeWrapper;
        else {
            NodeWrapper iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNodeWrapper);
        }
        size++;
    }
    
    public void insertFront(Node node) {
        NodeWrapper n = new NodeWrapper(node);
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
            NodeWrapper iterator = this.first;
            NodeWrapper previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
            size--;
        }
    }

    public void deleteFront(){
        if (this.first != null){
            first = first.getNext();
            size--;
        }
    }

    public void deleteAll(){
        first = null;
    }

    public String[] listAll() {
        String[] list = new String[this.size];
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
