public class List {

    private Node first = null;


    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }


    public boolean vacia() {
        return this.first == null;
    }


    public void meteFinal(String value) {
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


    public void meteInicio(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
    }


    public void borraFinal() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            if (previous != null) {
                previous.setNext(null);
            }
        }
    }


    public void borraInicio() {
        if (this.first != null) {
            Node temp = this.first;
            this.first = this.first.getNext();
            temp.setNext(null);
        }
    }


    public String[] muestra() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }


    public List localiza(String value) {
        List foundList = new List();
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundList.meteFinal(iterator.getValue());
            }
            iterator = iterator.getNext();
        }
        return foundList;
    }


    public void vaciar() {
        this.first = null;
    }
}
