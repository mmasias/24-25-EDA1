package Reto002;

public class FoundNodeWrapper {
    private Node node;
    private FoundNodeWrapper next;

    public FoundNodeWrapper(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public FoundNodeWrapper getNext() {
        return next;
    }

    public void setNext(FoundNodeWrapper newNode) {
        this.next = next;
    }
    
}
