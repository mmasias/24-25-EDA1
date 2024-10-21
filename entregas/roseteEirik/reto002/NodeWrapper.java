package entregas.roseteEirik.reto002;

public class NodeWrapper {
    private Node node;
    private NodeWrapper nextNodeWrapper;

    public NodeWrapper(Node node) {
        this.setNode(node);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node newNode) {
        this.node = newNode;
    }

    public NodeWrapper getNextNode() {
        return nextNodeWrapper;
    }

    public void setNextNode(NodeWrapper nextNodeWrapper) {
        this.nextNodeWrapper = nextNodeWrapper;
    }
}