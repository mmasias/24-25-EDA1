public class PlayListLinkedList {
    private PlayListNode head;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public void addPlayList(PlayList value) {
        PlayListNode newNode = new PlayListNode(value);
        if (this.head == null) {
            this.head = newNode;
            size++;
        } else {
            PlayListNode iterator = this.head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
            size++;
        }
    }

    public void removePlayList(int index) {
        PlayListNode previous = head;
        PlayListNode current = head;
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

    public PlayList get(int index) {
        PlayListNode current = head;
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

    public PlayList[] listAll() {
        PlayList[] list = new PlayList[this.size()];
        PlayListNode iterator = this.head;
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
        PlayListNode current = head;
        int count = 0;
        while (current != null) {
            data += count + ". " + current.getValue().toString() + "\n";
            current = current.getNext();
            count++;
        }
        return data;
    }
}