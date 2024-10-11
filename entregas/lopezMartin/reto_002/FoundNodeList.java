public class FoundNodeList {
    
    private NodeWrapper first = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size > 0;
    }

    public void insertEnd(String value) {
        NodeWrapper newNodeWrapper = new NodeWrapper(value);
        if (this.first == null){
            this.first = newNodeWrapper;
        }else {
            NodeWrapper iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNodeWrapper);
        }
        size++;
    }
    
}
