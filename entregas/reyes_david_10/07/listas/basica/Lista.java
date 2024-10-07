import org.w3c.dom.Node;

public class Lista {

    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNextSibling() != null) {
            count++;
            iterator = iterator.getNextSibling();
        }
        return count;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNextSibling() != null) {
                iterator = iterator.getNextSibling();
            }
            ((Object) iterator).setNext(newNode);
        }
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNextSibling() != null) {
                previous = iterator;
                iterator = iterator.getNextSibling();
            }
            previous.setNext(null);
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNextSibling();
        }
    }

    public void deleteAll() {
        this.first = null;
    }

    public Node[] find(String value) {
        int count = 0;
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                count++;
            }
            iterator = iterator.getNextSibling();
        }

        Node[] matches = new Node[count];

        iterator = this.first;
        int index = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                matches[index] = iterator;
                index++;
            }
            iterator = iterator.getNextSibling();
        }

        return matches;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNextSibling();
        }
        return list;
    }
}