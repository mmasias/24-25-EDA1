public class List {

    private Node first = null;
    private int size = 0;
    

    public int size() {
        return this.size;
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
        this.size++;
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        this.size++;
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
            this.size--;
        }
    }

    public void deleteFront(){
        if(this.first != null){
            this.first = this.first.getNext();
            this.size--;
        }
    }

    public void deleteAll(){
        first = null;
    }

    public Node[] find(String value){
        Node[] results = new Node[this.size()];
        int count = 0;
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                results[count++] = iterator;
            }
            iterator = iterator.getNext();
        }
        Node[] finalResults = new Node[count];
        for (int i = 0; i < count; i++) {
            finalResults[i] = results[i];
        }
        return finalResults;
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