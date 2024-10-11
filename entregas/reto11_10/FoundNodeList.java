package entregas.reto11_10;

public class FoundNodeList {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public void add(Node node) {
        Node newNode = new Node(node.getValue()); 
        if (this.first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }

    public int size() {
        return this.size;
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
}
