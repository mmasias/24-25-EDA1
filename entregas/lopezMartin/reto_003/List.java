package entregas.lopezMartin.reto_003;

public class List {

    private Node first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size > 0;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value, this.size);
        if (this.first == null){
            this.first = newNode;
        }else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }

    public boolean incluye(String value) {

        Node iterator = this.first;
    
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
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

    public Node obtenerUltimo(){
        
        if (this.first == null) {
        return null;
        }  
    
        Node iterator = this.first;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
    
        return iterator;
    }

    public String getIndiceOf(String value) {
        
        Node iterator = this.first;
    
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return Integer.toString(iterator.getIndice());
            }
            iterator = iterator.getNext();
        }
        return null;

    }

    public String getValueOf(String value) {

        Node iterator = this.first;
    
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return iterator.getValue();
            }
            iterator = iterator.getNext();
        }
        return null;
        
    }
}