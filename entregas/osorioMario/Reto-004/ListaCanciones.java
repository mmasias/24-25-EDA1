public class ListaCanciones {
    private Node head;
    private int size;

    public ListaCanciones() {
        this.head = null;
        this.size = 0;
    }

    public void agregarCancion(Cancion cancion) {
        Node nuevoNodo = new Node(cancion);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(nuevoNodo);
        }
        size++;
    }

    public void mostrarLista() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public Cancion obtenerCancion(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }
}
