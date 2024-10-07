package entregas.vaqueroInigo.ListaBasica;

public class List {

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
        size++;  
    }
    
    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null) {
            this.first = n;
        } else {
            n.setNext(this.first);
            this.first = n;
        }
        size++;  
    }

    public void deleteEnd() {
        if (this.first != null) {
            if (this.first.getNext() == null) {
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
            size--; 
        }
    }

    public void deleteByValue(String value) {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator != null) {
                if (iterator.getValue().equals(value)) {
                    if (previous == null) {
                        this.first = iterator.getNext();
                    } else {
                        previous.setNext(iterator.getNext());
                    }
                    size--; 
                    return;
                }
                previous = iterator;
                iterator = iterator.getNext();
            }
        }
    }

    public void deleteFront() {  
        if (this.first != null) {
            this.first = this.first.getNext();
            size--;  
        }
    }

    public void clear() {
        this.first = null;
        this.size = 0; 
    }

    public Node search(String criterion) {
        Node iterator = this.first;
        while (iterator != null) {
            if (iterator.getValue().contains(criterion)) {  
                return iterator;  
            }
            iterator = iterator.getNext();
        }
        return null; 
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
