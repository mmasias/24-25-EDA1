/*Se discutió en clase qué inconvenientes tenía el resolverlo con un array
Se acordó que la forma natural de hacerlo sería mediante otra lista, pero!
Se vió como el manejo inadecuado de listas podía afectar (y de hecho, afectaba) la lista original.*/

/*Reto
Implemente una forma en la que se pueda responder a la búsqueda sin afectar la lista original.

La vista pública del método sería:

  public FoundNodeList find(String value) {}
Que devuelve la lista de nodos que responden al criterio consultado. */

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
        this.size++;
    }

    public void insertFront(String value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        this.size++;
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
            this.size--;
        }
    }

    public void deleteFront() {
        if (this.first != null) {
            this.first = this.first.getNext();
            this.size--;
        }
    }

    public void clearList() {
        this.first = null;
        this.size = 0;
    }

    public Node[] find(String value) {
        Node iterator = this.first;
        Node[] nodes = new Node[this.size];
        int count = 0;
        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                nodes[count] = iterator;
                count++;
            }
            iterator = iterator.getNext();
        }
        return nodes;
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