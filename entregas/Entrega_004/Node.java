package entregas.Entrega_004;

public class Node {
    private Cancion data;
    private Node next;

    public Node(Cancion data) {
        this.data = data;
        this.next = null;
    }

    public Cancion getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}