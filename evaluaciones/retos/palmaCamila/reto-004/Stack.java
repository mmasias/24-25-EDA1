public class Stack {
    private SongNode top;

    public Stack() {
        this.top = null;
    }

    public void push(Song data) {
        SongNode newNode = new SongNode(data);
        newNode.setNext(top);
        top = newNode;
    }

    public Song pop() {
        if (top == null) {
            return null;
        }
        Song data = top.getValue();
        top = top.getNext();
        return data;
    }

    public Song peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String data = "";
        SongNode iterator = this.top;
        while (iterator != null) {
            data += iterator.getValue().toString() + "\n";
            iterator = iterator.getNext();
        }
        return data;
    }
}