public class Node {
    private String value;
    private int indice;
    private Node next;

    public Node(String value, int indice) {
        this.value = value;
        this.indice = indice;
        this.next = null;
    }

    public String getValue() {
        return value;
    }

    public int getIndice() {
        return indice;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
