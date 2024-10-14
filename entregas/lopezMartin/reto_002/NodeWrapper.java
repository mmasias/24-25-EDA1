
public class NodeWrapper {

    private NodeWrapper next;
    private Node node;

    public NodeWrapper(String value){

        this.node = new Node(value);

    }

    public NodeWrapper getNext() {
        return next;
    }

    public void setNext(NodeWrapper next) {
        this.next = next;
    }

    public Node getNode(){
        return node;
    }

}
