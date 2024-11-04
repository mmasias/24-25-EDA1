public class SongsLinkedList {
    private SongNode head;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public void addSong(Song value) {
        SongNode newNode = new SongNode(value);
        if (this.head == null) {
            this.head = newNode;
            size++;
        } else {
            SongNode iterator = this.head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
            size++;
        }
    }

    public void removeSong(int index) {
        SongNode previous = head;
        SongNode current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                if (index == 0) {
                    head = current.getNext();
                }
                previous.setNext(current.getNext());
                current.setNext(null);
                size--;
                return;
            }
            count++;
            previous = current;
            current = current.getNext();
        }
    }

    public Song get(int index) {
        SongNode current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            count++;
            current = current.getNext();
        }
        return null;
    }

    public Song[] listAll() {
        Song[] list = new Song[this.size()];
        SongNode iterator = this.head;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }

    @Override
    public String toString() {
        String data = "";
        SongNode current = head;
        int count = 0;
        while (current != null) {
            data += count + ". " + current.getValue().toString() + "\n";
            current = current.getNext();
            count++;
        }
        return data;
    }
}