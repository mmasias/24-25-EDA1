public class ListOld {
    
    private int size = 0;
    private Node first = null;

    public int size() {
        if (this.first == null) {
            return 0;
        }
        int count = 1;
        Node iterator = first;
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.getNext();
        }
        return count;
    }
    
    public int betterSize(){
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() > 0 ? false : true;
    }

    public void insertEnd(String value) {
        Node newNode = new Node(value);
        if (this.first == null){
            this.first = newNode;
        }
        else {
            Node iterator = this.first;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
        this.size++;
    }

    public void insertFront(String value) {
        Node n = new Node(value);
        if (this.first == null)
            this.first = n;
        else {
            n.setNext(this.first);
            this.first = n;
        }
        this.size++;
    }

    public void deleteLast() {
        if (this.first != null) {
            Node iterator = this.first;
            Node previous = null;
            while (iterator.getNext() != null) {
                previous = iterator;
                iterator = iterator.getNext();
            }
            previous.setNext(null);
        }
        this.size--;
    }

    public void deleteFirst(){
        if (this.first != null && this.first.getNext() != null){
            this.first = this.first.getNext();
        } 
        this.size--;
    }

    public void deleteAll(){
        this.first = null;
    }

    public FoundList find(String value){
        FoundList foundList = new FoundList();
        if (this.first != null){
            Node iterator = first;
            while (iterator != null){
                if (iterator.getValue().equals(value)){
                    foundList.insertEnd(iterator);
                }
                iterator = iterator.getNext();
            }
            return foundList;
        } else {
            return foundList;
        }
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

    public void mostrar(){
        Node iterator = this.first;
            do{
                System.out.print(iterator + " ");
                iterator.show();
                iterator = iterator.getNext();
            }while (iterator != null);
    }
}