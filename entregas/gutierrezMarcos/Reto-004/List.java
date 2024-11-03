public class List {

    private Node first = null;
    private int size = 0;
    private Node last;
    private String name;
    private List list;

    public List(String name) {
        this.name = name;
        this.first = null;
        this.last = null;
    }

    public List() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insertEnd(Cancion cancion) {
        Node newNode = new Node(cancion, size);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
            newNode.setPrevious(iterator);
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

    public String mostrar() {
        String list = "";
        Node iterator = this.first;
        if (iterator == null)
            return list;
        while (iterator != null) {
            list += "" + iterator.getIndice() + ". " + iterator.getValue() + "\n";
            iterator = iterator.getNext();
        }
        return list;
    }

    public Node obtenerUltimo() {
        return this.last;
    }

    public String getIndiceOf(String value) {

        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getValue().equals(value)) {
                return Integer.toString(iterator.getIndice());
            }
            iterator = iterator.getNext();
        }
        return "0";

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

    public Cancion getCancion(int index) {
        index--;

        Node iterator = this.first;
        int currentIndex = 0;

        while (iterator != null) {
            if (currentIndex == index) {
                return iterator.getSong();
            }
            iterator = iterator.getNext();
            currentIndex++;
        }

        return null;

    }

    public Cancion next(Cancion currentSong) {
        Node iterator = this.first;

        while (iterator != null) {
            if (iterator.getSong().equals(currentSong)) {
                if (iterator.getNext() != null) {
                    return iterator.getNext().getSong();
                } else {
                    return null;
                }
            }
            iterator = iterator.getNext();
        }

        return null;
    }

    public Cancion previous(Cancion currentSong) {
        Node iterator = this.first;
        Node previousNode = null;

        while (iterator != null) {
            if (iterator.getSong().equals(currentSong)) {
                return previousNode != null ? previousNode.getSong() : null;
            }
            previousNode = iterator;
            iterator = iterator.getNext();
        }

        return null;
    }

    public String mostrarDesde(String value) {
        Node iterator = this.first;
        StringBuilder result = new StringBuilder();
        boolean found = false;
        int colaIndex = 1;

        while (iterator != null) {
            if (!found && iterator.getValue().equals(value)) {
                result.append("Sonando: ").append(iterator.getValue()).append("\n\n");
                found = true;
            } else if (found) {
                result.append(colaIndex).append(" - ").append(iterator.getValue()).append("\n");
                colaIndex++;
            }
            iterator = iterator.getNext();
        }

        return result.toString();
    }

    public String mostrarFavoritas() {
        StringBuilder result = new StringBuilder();
        Node current = first;

        while (current != null) {
            if (current.getSong().isFavorita()) {
                result.append(current.getIndice()+1).append(" - ").append(current.getSong().toString()).append("\n");
            }
            current = current.getNext();
        }

        return result.length() > 0 ? result.toString() : "No tienes canciones favoritas.\n";
    }

    public void add(Cancion cancion) {
        Node newNode = new Node(cancion);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void crearPlaylist(List list) {
        this.list = list;
        this.first = new Node(list);
        this.last = this.first;
        this.size = 1;
    }

    public String getName(){
        return name;
    }

    public void remove(int index) {

        Node current = first;
        Node previous = null;

        for (int i = 1; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        if (current == last) {
            last = previous;
        }

        size--;
    }

    public String mostrarCanciones() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        int index = 1;

        while (current != null) {
            sb.append(index).append(". ").append(current.getSong().toString()).append("\n");
            current = current.getNext();
            index++;
        }

        return sb.toString();
    }

    public Node getFirst() {
        return first;
    }
}