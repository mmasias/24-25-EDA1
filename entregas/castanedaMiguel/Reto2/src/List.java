
public class List {

    private Node first = null;
    private int tamaño = 0;

    public int size() {
        return this.tamaño;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null)
            this.first = newNode;
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.tamaño++;
    }

    public void insertFront(String value) {
        Node n = new Node(value);
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
            Node iterator = this.first;
            Node previous = null;
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
            Node secondNode=this.first.getNext();
            this.first=secondNode;
        }
        this.tamaño--;
    }

    public void deleteAll(){
        this.first=null;
        this.tamaño=0;
    }

    public NodeWrapperList find(String value){
        NodeWrapperList resultado=new NodeWrapperList();
        if(this.first!=null){
            Node node=this.first;
            while(node!=null){
                if(node.getValue().equals(value)){
                    resultado.insertEnd(node);
                }
                node=node.getNext();
            }
        }
        return resultado;
    }

    public String[] listAll() {
        String[] list = new String[this.size()];
        Node iterator = this.first;
        if (iterator == null)
            return list;
        int count = 0;
        while (iterator != null) {
            list[count] = iterator.getValue();
            count++;
            iterator = iterator.getNext();
        }
        return list;
    }
}
