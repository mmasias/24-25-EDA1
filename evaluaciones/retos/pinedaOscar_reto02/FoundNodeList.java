package evaluaciones.retos.pinedaOscar_reto02;

public class FoundNodeList {
    private Node first = null;

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public String[] listAll() {
        int size = 0;
        Node iterator = first;
        while (iterator != null) {
            size++;
            iterator = iterator.getNext();
        }

        String[] values = new String[size];
        iterator = first;
        int index = 0;
        while (iterator != null) {
            values[index++] = iterator.getValue();
            iterator = iterator.getNext();
        }
        return values;
    }
}