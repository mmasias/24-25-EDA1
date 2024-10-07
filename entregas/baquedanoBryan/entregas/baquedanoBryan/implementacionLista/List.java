package entregas.baquedanoBryan.implementacionLista;

public class List {

    private Node first = null;
    public int size = 0;


    public boolean isEmpty( ) {
        return this.size > 0 ? false : true;
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
        }

        this.size--;

    }

    public void deleteFront(){
        if (this.first != null){
            first = first.getNext();
            size--;
        }
    }

    public Node[] find(String value) {
        Node[] list = new Node[this.size];
        int index = 0;
        Node iterator = first;
            
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                list[index] = iterator;
                index++;
            }
            iterator = iterator.getNext();
        }
    
        if (index == 0) {
            System.out.println("No se encontró el valor '" + value + "' en la lista.");
        } else {
            System.out.println("Se encontraron " + index + " nodo(s) con el valor '" + value + "'.");
        }
        
        return list;
    }

    public String[] listAll() {
        String[] list = new String[this.size];
        Node iterator = this.first;
        
        if (iterator == null) {
            System.out.println("La lista está vacía.");
            return list;
        }
    
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        System.out.println("Elementos actuales en la lista: " + java.util.Arrays.toString(list));    
        return list;
    }

    public void deleteAll(){
     this.first = null;  
     this.size = 0;      
        
    }
}