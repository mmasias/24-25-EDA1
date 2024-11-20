package entregas.nevesKelvia.Reto_002;

public class FoundNodeList {
    private Node first = null;  
    private int count = 0;     

    public void insertEnd(Node node) {
        Node newNode = new Node(node.getValue());  
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        count++;
    }
    
    public int size() {
        return count;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        int index = 0;
        while (iterator != null) {
            list[index] = iterator.getValue();
            index++;
            iterator = iterator.getNext();
        }
        return list;
    }
}