public class Node {

    private Cancion cancion;
    private Node next;

    public Node(Cancion value) {
        this.setValue(value);
    }

    public Cancion getValue() {
        return cancion;
    }

    public void setValue(Cancion newValue) {
        this.cancion = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void show(){
        System.out.println(" [" + cancion.toString() + " ]");
    }
}