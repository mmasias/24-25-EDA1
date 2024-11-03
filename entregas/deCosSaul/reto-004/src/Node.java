public class Node {
    private Object value;  // Cambiado a Object para almacenar cualquier tipo
    private Node next;

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void show() {
        System.out.println(value.toString());
    }
}