package entregas.reto0710;

public class List {

    private Node first = null;
    private Node last = null; 
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
            this.last = newNode;
        } else {
            
            this.last.setNext(newNode);
            this.last = newNode;  
        }
        this.size++;  
    }

    
    public void insertFront(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        this.size++;  
    }

    public void deleteEnd() {
        if (this.first != null) {
            if (this.first == this.last) {
                this.first = null;
                this.last = null;
            } else {
                Node iterator = this.first;
                while (iterator.getNext() != this.last) {
                    iterator = iterator.getNext();
                }
                iterator.setNext(null); 
                this.last = iterator;  
            }
            this.size--; 
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext(); 
            if (this.first == null) {
                this.last = null;
            }
            this.size--;
        }
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public int find(String value) {
        Node iterator = this.first;
        int index = 0;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return index;  
            }
            iterator = iterator.getNext();
            index++;
        }

        return -1;  
    }

    public Node findNode(String value) {
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return iterator;  
            }
            iterator = iterator.getNext();
        }

        return null;  
    }
}
