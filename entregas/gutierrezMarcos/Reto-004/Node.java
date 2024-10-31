public class Node {

    private String value;
    private int indice;
    private Node next;

    public Node(Cancion cancion, int indice) {
        this.setValue(cancion.toString());
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
