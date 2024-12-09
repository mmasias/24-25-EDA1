public class DictionaryElement {
    private String element;
    private int index;


    public DictionaryElement(int index, String actualSegment) {
        this.index=index;
        element=actualSegment;

    }
    public String getElement() {
        return element;
    }
    public int getIndex() {
        return index;
    }

}
