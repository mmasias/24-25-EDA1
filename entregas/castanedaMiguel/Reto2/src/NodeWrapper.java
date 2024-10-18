public class NodeWrapper{

    private Node node;
    private NodeWrapper next;

    public NodeWrapper(Node NewNode){
        this.node=NewNode;
        this.next=null;
    }
    public NodeWrapper(){
        this.node=null;
        this.next=null;
    }

    public Node getNode(){
        return this.node;
    }

    public void setNode(Node NewNode){
        this.node=NewNode;
    }

    public NodeWrapper getNext(){
        return next;
    }

    public void setNext(NodeWrapper NewNodeWrapper){
        this.next=NewNodeWrapper;
    }
}
