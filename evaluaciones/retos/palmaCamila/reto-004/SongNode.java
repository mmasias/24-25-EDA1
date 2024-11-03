public class SongNode {

    private Song value;
    private SongNode next;

    public SongNode(Song value) {
        this.setValue(value);
    }

    public Song getValue() {
        return value;
    }

    public void setValue(Song newValue) {
        this.value = newValue;
    }

    public SongNode getNext() {
        return next;
    }

    public void setNext(SongNode next) {
        this.next = next;
    }
}