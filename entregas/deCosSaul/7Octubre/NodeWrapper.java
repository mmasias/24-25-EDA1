class NodeWrapper {
    private Node matchNode;
    private NodeWrapper next;

    public NodeWrapper(Node node){
        this.matchNode = node;
    }
    public NodeWrapper getNext(){
        return next;
    }

    public void setNext(NodeWrapper next){
        this.next = next;
    }
    public void show(){
        this.matchNode.show();
    }
    public Node returnNode(){
        return matchNode;
    }
}
