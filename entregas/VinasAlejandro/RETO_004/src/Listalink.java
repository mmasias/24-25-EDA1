import java.util.Random;

class Listalink<T> extends List<T> {
    private Node<T> tail;

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public T getRandomElement(Random random) {
        if (isEmpty()) return null;
        int size = getSize();
        int randomIndex = random.nextInt(size);
        Node<T> current = head;
        for (int i = 0; i < randomIndex; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }



}