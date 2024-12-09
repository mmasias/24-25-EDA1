public class Node {

    private String value;
    private int row;
    private Node nextNode;

    public Node(String value, int row) {
        this.value=value;
        this.row=row;
        nextNode=null;
    }

    public Node(String value, int row, Node node) {
        this.value=value;
        this.row=row;
        this.nextNode=node;
    }

    public String getValue() {
        return value;
    }

    public int getRow(){
        return row;
    }

    public Node getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node node){
        nextNode=node;
    }

}
