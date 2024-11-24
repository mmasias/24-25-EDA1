package entregas.roseteEirik.reto004;

public class List {

    private Node first = null;

    public int size() {
        int count = 0;
        Node iterator = this.first;
        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
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
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
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
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
    }

    public void deleteFront() {
        if (this.first == null) {
            return;
        } else {
            this.first = this.first.getNext();
        }
    }

    public void deleteAll() {
        this.first = null;
    }

    public boolean searchValue(String value) {
        Node iterator = this.first;
        while (iterator != null) {
            if (value != null && value.equals(iterator.getValue())) {
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
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
            iterator = iterator.getNext();
        }
        return list;
    }
}
