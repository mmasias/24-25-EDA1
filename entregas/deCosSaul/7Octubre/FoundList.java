class FoundList {
    private int size = 0;
    private NodeWrapper first = null;

    public void insertEnd(Node node) {
        NodeWrapper newNode = new NodeWrapper(node);
        if (this.first == null){
            this.first = newNode;
        }
        else {
            NodeWrapper iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
    }
    public int getSize(){
        return size;
    }
    public void mostrar(){
        NodeWrapper iterator = this.first;
            do{
                System.out.print(iterator.returnNode() + " ");
                iterator.show();
                iterator = iterator.getNext();
            }while (iterator != null);
    }
}
