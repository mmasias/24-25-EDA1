package entregas.nevesKelvia.Reto_07_10;

public class List {

    private Node first = null;
    private int count = 0;  

    public int size() {
        return count; 
    }

    public boolean isEmpty() {
        return this.size() == 0;
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
        count++;  
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        count++;  
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
            count--;  
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext(); 
            count--;
        }
    }

    public Node[] find(String value) {
        Node[] results = new Node[this.size()]; 
        int foundCount = 0;
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().contains(value)) {  
                results[foundCount] = iterator;
                foundCount++;
            }
            iterator = iterator.getNext();
        }

        Node[] trimmedResults = new Node[foundCount];
        System.arraycopy(results, 0, trimmedResults, 0, foundCount);
        return trimmedResults;
    }

    public void clear() {
        this.first = null;  
        this.count = 0;     
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int index = 0;
        while (iterator != null) {
            list[index] = iterator.getValue();
            index++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
