public class PlayListNode {

    private PlayList value;
    private PlayListNode next;

    public PlayListNode(PlayList value) {
        this.setValue(value);
    }

    public PlayList getValue() {
        return value;
    }

    public void setValue(PlayList newValue) {
        this.value = newValue;
    }

    public PlayListNode getNext() {
        return next;
    }

    public void setNext(PlayListNode next) {
        this.next = next;
    }
}