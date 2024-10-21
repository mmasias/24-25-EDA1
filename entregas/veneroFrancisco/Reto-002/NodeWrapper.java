public class NodeWrapper {
    private Node node;
    private NodeWrapper next;

    public NodeWrapper(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("El nodo no puede ser nulo");
        }
        this.node = node; 
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("El nodo no puede ser nulo");
        }
        this.node = node;
    }

    public NodeWrapper getNext() {
        return next;
    }

    public void setNext(NodeWrapper next) {
        this.next = next;
    }
}
