public class List {

    private Node first;
    private int size;

    public List() {
        this.clear();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
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
        size++;
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        size++;
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
        size--;
    }

    public void deleteFront(){
        if (this.first != null) {
            this.first = this.first.getNext();
        }
    }

    public void deleteAll(){
        this.clear();
    }

    private void clear(){
        this.first = null;
        this.size=0;
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

    public void showInConsole() {
        System.out.println("=".repeat(25));
        System.out.println("Fila de " + this.size());
        System.out.println("-".repeat(25));
        if (this.first != null) {
            Node iterator = this.first;
            while (iterator != null) {
                System.out.print(iterator.getValue() + " / ");
                iterator = iterator.getNext();
            }
        }
        System.out.println();
    }

    public List find(String value) {
        List foundList = new List();
        if (this.first != null) {
            Node iterator = this.first;

            while (iterator != null) {
                if (iterator.getValue().equals(value)) {
                    foundList.insertEnd(iterator.getValue());
                }
                iterator = iterator.getNext();
            }

            return foundList;
        }
        return foundList;
    }
}
