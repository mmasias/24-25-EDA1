public class NodeStack {
    private Node top ;

    public NodeStack(){
        top=null;
    }   
    
    public void push(String value, int row) {
        if (top == null) {
            top=new Node(value, row);
        } else {
            top=new Node(value, row, top);
        }
    }

    public Node pop() {
        if (top==null) {
            return null;
        } else {
            Node node = top;
            top = top.getNextNode();
            return node;
        }
    }
}
