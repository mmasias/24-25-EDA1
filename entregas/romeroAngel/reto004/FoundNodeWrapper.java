package romeroAngel.reto004;

class FoundNodeWrapper {
    
    private Node foundNode;
    private FoundNodeWrapper next;

    public FoundNodeWrapper(Node foundNode) {
        this.foundNode = foundNode;
        this.next = null;
    }

    public Node getFoundNode() {
        return foundNode;
    }

    public FoundNodeWrapper getNext() {
        return next;
    }

    public void setNext(FoundNodeWrapper next) {
        this.next = next;
    }
}
