public class FoundNodeList {

    public Node[] listAll() {
        Node[] list = new Node[this.size];
        FoundNode iterator = this.first;
        int index = 0;
        while (iterator != null) {
            list[index] = iterator.getOriginalNode();
            index++;
            iterator = iterator.getNext();
        }
        return list;
    }

    private FoundNode first = null;
    public int size = 0;

    public void insert(Node node) {
        FoundNode newNode = new FoundNode(node);
        if (this.first == null)
            this.first = newNode;
        else {
            FoundNode iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        size++;
    }
}
