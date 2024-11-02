package entregas.lopezMartin.reto_003;

public class Node {

    private String value;
    private int indice;
    private Node next;

    public Node(String value, int indice) {
        this.setValue(value);
        this.indice = indice;
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

    public int getIndice(){
        return this.indice;
    }
}
