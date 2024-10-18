public class NodeWrapper{
    private Node node;
    private NodeWrapper nextNodeWrapper;

    public NodeWrapper(Node node) {
        this.setValue(node);
    }

    public Node getValue() {
        return node;
    }

    public void setValue(Node newNode) {
        this.node= newNode;
    }

    public NodeWrapper getNext() {
        return this.nextNodeWrapper;
    }

    public void setNext(NodeWrapper next) {
        this.nextNodeWrapper = next;
    }
}
