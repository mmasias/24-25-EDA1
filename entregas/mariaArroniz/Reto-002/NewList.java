class NewList {
    private NodeWrap first = null;
    int size = 0;

    private addNode(NodeWrap nodeWrap){
        NodeWrap newNodeWrap = new NodeWrap(node);
        if (this.first == null) {
            this.first = newNodeWrap;
        } else {
            NodeWrap iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNodeWrap);
        }
        size++;
    }
    
}
