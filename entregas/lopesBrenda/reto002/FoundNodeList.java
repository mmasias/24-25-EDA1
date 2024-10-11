package entregas.lopesBrenda.reto002;

public class FoundNodeList extends List {

    public void insertEnd(FoundNodeWrapper valueWrapper) {

        Node newNode = new Node(valueWrapper.getValue());
        
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }
}
