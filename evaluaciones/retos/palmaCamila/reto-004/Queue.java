public class Queue {
    private SongNode front;
    private SongNode rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Song data) {
        SongNode newNode = new SongNode(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public Song dequeue() {
        if (front == null) {
            return null;
        }
        Song data = front.getValue();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public Song peek() {
        if (front == null) {
            return null;
        }
        return front.getValue();
    }

    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public String toString() {
        String data = "";
        SongNode iterator = this.front;
        while (iterator != null) {
            data += iterator.getValue().toString() + "\n";
            iterator = iterator.getNext();
        }
        return data;
    }
}