package entregas.naranjoDylan.Listas;

public class List {

    private Node first = null;
    private int count = 0;

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

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
        this.count++;
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            n.setNext(this.first);
            this.first = n;
        }
        this.count++;
    }

    public void deleteEnd() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
        this.count--;
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            this.count--;
        }
    }

    public void clearlist() {
        this.first = null;
        this.count = 0;
    }

    public List find(String value) {
        List foundList = new List();
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundList.insertEnd(iterator.getValue());
            }
            iterator = iterator.getNext();
        }
        return foundList;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null) {
            return list;
        }
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
