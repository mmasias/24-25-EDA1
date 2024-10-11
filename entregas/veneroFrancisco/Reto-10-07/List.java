import java.util.ArrayList; 
class List {
    
    private Node first = null;
    private int size = 0; 
    public int size() {
        return this.size; 
    }
    
    public boolean isEmpty() {
        return this.size == 0;
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
        this.size++; 
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        n.setNext(this.first);
        this.first = n;
        this.size++; 
    }
   
    public void deleteLast() {
        if (this.first != null) {
            if (this.first.getNext() == null) { // Solo un elemento
                this.first = null;
            } else {
                Node iterator = this.first;
                Node previous = null;
                while (iterator.getNext() != null) {
                    previous = iterator;
                    iterator = iterator.getNext();
                }
                previous.setNext(null); 
            }
            this.size--; 
        }
    }
    
    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext(); 
            this.size--; 
        }
    }
    
    public Node[] find(String value) {
        ArrayList<Node> foundNodes = new ArrayList<>(); 
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                foundNodes.add(iterator); 
            }
            iterator = iterator.getNext();
        }
        return foundNodes.toArray(new Node[0]); 
    }
   
    public String[] listAll() {
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
}
