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

    
}
