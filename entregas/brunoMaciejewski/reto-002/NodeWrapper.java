public class NodeWrapper {

    private Node node;
    private NodeWrapper next;

    public NodeWrapper(Node node) {
        this.node=node;
    }

    public String getValue() {
        return node.getValue();
    }

    public void setValue(String newValue) {
        this.value = node.setValue(newValue);
    }

    public NodeWrapper getNext() {
        return next;
    }

    public void setNext(NodeWrapper next) {
        this.next = next;
    }
}
