class NodeWrap {

    private String value;
    private NodeWrap next;

    public NodeWrap (Node node){
        this.node = node;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        this.value = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}