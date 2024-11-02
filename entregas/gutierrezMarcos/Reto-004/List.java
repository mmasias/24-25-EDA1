public class List {

    private Node first = null;
    private int size = 1;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size > 0;
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
}