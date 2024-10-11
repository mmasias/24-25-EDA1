package entregas.DiegoJimenez.reto002;

class NodeWrapper {
    private Node originalNode;

    public NodeWrapper(Node originalNode) {
        this.originalNode = originalNode;
    }

    public Node getOriginalNode() {
        return originalNode;
    }

    public String getValue() {
        return originalNode.getValue();
    }

    public Node getNext() {
        return originalNode.getNext();
    }
}

