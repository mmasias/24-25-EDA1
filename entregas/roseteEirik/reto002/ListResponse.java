package entregas.roseteEirik.reto002;

public class ListResponse {

    private NodeWrapper first = null;

    public int size() {
        return this.size();
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(Node node) {
        NodeWrapper newNodeWrapper = new NodeWrapper(node);
        if (this.first == null)
        this.first = newNodeWrapper;
        else { 
            NodeWrapper iterator = this.first;
            while (iterator.getNextNode() != null) {
                iterator = iterator.getNextNode();
            }
            iterator.setNextNode(newNodeWrapper);
        }
    }
    
    public void insertFront(Node node) {
        NodeWrapper nw = new NodeWrapper(node);
        if (this.first == null)
            this.first = nw;
        else {
            nw.setNextNode(this.first);
            this.first = nw;
        }
    }

    public void deleteEnd() {
        if (this.first != null) {
            NodeWrapper iterator = this.first;
            NodeWrapper previous = null;
            while (iterator.getNextNode() != null) {
                previous = iterator;
                iterator = iterator.getNextNode();
            }
            previous.setNextNode(null);
        }
    }

    public void deleteFront() {
        if (this.first == null) {
            return;
        } else {
            this.first = this.first.getNextNode();
        }
    }

    public void deleteAll() {
        this.first = null;
    }

    public boolean searchValue(Node node) {
        NodeWrapper iterator = this.first;
        while (iterator != null) {
            if (node != null && node.equals(iterator.getNode())) {
                return true;
            }
            iterator = iterator.getNextNode();
        }
        return false;
    }

    public Node[] valuesFound(Node node) {
        Node[] list = new Node[this.size()];
        NodeWrapper iterator = this.first;
        while (iterator != null) {
            if (node != null && node.equals(iterator.getNode())) {
                insertEnd(node);
            }
            iterator = iterator.getNextNode();
        }
        return list;
    }

    public Node[] listAll() {
        Node[] list = new Node[this.size()];
        NodeWrapper iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getNode();
            count++;
            iterator = iterator.getNextNode();
        }
        return list;
    }
    
}
