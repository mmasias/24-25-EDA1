package romeroAngel.reto004;
public class List {

    private Node first;
    private int tamaño;

    public List() {
        this.clear();
    }

    public int size() {
        return tamaño;
    }

    public boolean isEmpty() {
        return this.tamaño <= 0;
    }

    public void insertEnd(Cancion cancion) {
        Node newNode = new Node(cancion);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        tamaño++;
    }

    public void insertFront(Cancion cancion) {
        Node newNode = new Node(cancion);
            newNode.setNext(this.first);
            this.first = newNode;
            tamaño++;
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
        tamaño--;
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            tamaño--;
        }
    }

    public void deleteAll() {
        this.clear();
    }

    public void clear() {
        this.first = null;
        this.tamaño = 0;
    }

    public Cancion obtener(int index) {
        if (index < 0 || index >= tamaño) {
            System.out.println("Indice '" + index + "'invalido.");
        }
        Node iterator = first;
        for (int i = 0; i < index; i++) {
            iterator = iterator.getNext();
        }
        return iterator.getCancion();
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getCancion().toString();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    public void showInConsole() {
        System.out.println("=".repeat(25));
        System.out.println("Lista de " + this.size() + " canciones");
        System.out.println("-".repeat(25));
        Node iterator = this.first;
        while (iterator != null) {
            System.out.print("[" + iterator.getCancion().toString() + "] / ");
            iterator = iterator.getNext();            
        }
        System.out.println();
    }

    public FoundNodeList find(String value) {
        FoundNodeList resultList = new FoundNodeList();
        if (this.first != null) {
            Node node = this.first;
            while (node != null) {
                if (node.getCancion().equals(value)) {
                    resultList.add(node);
                }
                node = node.getNext();
            }
        }
        return resultList;
    }

    public Node encontrarPrimer(String letra) {
        Node actual = this.first;

        while (actual!=null) {
            if (actual.getCancion().equals(letra)) {
                return actual;
            }
            actual = actual.getNext();
        }

        return null;
    }    

    public int obtenerIndice(Node nodo) {
        Node actual = this.first; 
        int indice = 1;
        
        while (actual != null) {
            if (actual == nodo) {
                return indice; 
            }
            actual = actual.getNext(); 
            indice++;
        }
        
        return -1; 
    }

    public Node getFirst() {
        return this.first; 
    }

    public boolean contains(Cancion cancion) {
        Node iterator = this.first;
        while (iterator != null) { 
            if (iterator.getCancion().equals(cancion)) { 
                return true; 
            }
            iterator = iterator.getNext(); 
        }
        return false; 
    }

}


