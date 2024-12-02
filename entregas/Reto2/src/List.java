public class List {

    private Node first = null;
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

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        }else {
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
            size--;
        }
    }

    public void deleteFront(){

        if (this.first !=null) {
            this.first = this.first.getNext();
            size--;
        }

    }

    public void deleteAll(){
        this.first = null;
        size = 0;
    }

    public FoundNodeList find(String value) {

        FoundNodeList foundNodes = new FoundNodeList();
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundNodes.insertEnd(iterator.getValue());
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
