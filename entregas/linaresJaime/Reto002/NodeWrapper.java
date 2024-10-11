package entregas.linaresJaime.Reto002;

public class NodeWrapper {
    private Node node;
    private NodeWrapper next;

    public NodeWrapper(Node node) {
        this.node=node;
    }

    public Node getNode() {
        return node;
    }

    public NodeWrapper getNext() {
        return next;
    }

    public void setNext(NodeWrapper next) {
        this.next = next;
    }
    
}
