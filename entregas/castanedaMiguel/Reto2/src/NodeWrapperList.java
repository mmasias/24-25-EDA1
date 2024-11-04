public class NodeWrapperList {

    private NodeWrapper first = null;
    private int tamaño = 0;

    public int size() {
        return this.size();
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(Node value) {
        NodeWrapper newNodeWrapper = new NodeWrapper(value);
        if (this.first == null)
            this.first = newNodeWrapper;
        else {
            NodeWrapper iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNodeWrapper);
        }
        this.tamaño++;
    }

    public void insertFront(Node value) {
        NodeWrapper n = new NodeWrapper(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        this.tamaño++;
    }

    public void deleteEnd() {
        if (this.first != null) {
            NodeWrapper iterator = this.first;
            NodeWrapper previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
        this.tamaño--;
    }

    public void deleteFront(){
        if(this.first != null){
            NodeWrapper secondNodeWrapper=this.first.getNext();
            this.first=secondNodeWrapper;
        }
        this.tamaño--;
    }

    public void deleteAll(){
        this.first=null;
        this.tamaño=0;
    }


    public String[] listAll() {
        String[] list = new String[this.size()];
        NodeWrapper iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getNode().getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
