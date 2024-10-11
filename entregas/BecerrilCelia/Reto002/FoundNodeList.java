package Reto002;

public class FoundNodeList {
    private FoundNodeWrapper first;
    private int size = 0;

    public FoundNodeList() {
        this.first = null;
        this.size = 0;

    }
    public void addNode(Node node) {
        FoundNodeWrapper newNode = new FoundNodeWrapper(node);
        if (this.first == null)
            this.first = newNode;
        else {
            FoundNodeWrapper iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
    }

    public FoundNodeWrapper getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }
}