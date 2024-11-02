public class Lista {
    
    private int size = 0;
    private Node first = null;

    public int size(){
        return this.size;
    }

    public void insertEnd(Cancion value) {
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

    public void deleteAll(){
        this.first = null;
    }

   // public FoundList find(String value){
  //      FoundList foundList = new FoundList();
   //     if (this.first != null){
   //         Node iterator = first;
   //         while (iterator != null){
   //             if (iterator.getValue().equals(value)){
   //                 foundList.insertEnd(iterator);
   //             }
   //             iterator = iterator.getNext();
   //         }
   //         return foundList;
   //     } else {
    //        return foundList;
   //     }
   // }

    public String listAll() {
        String salida = "";
        Node iterator = this.first;
        if (iterator == null)
            return salida;
        int count = 1;
        while (iterator != null) {
            salida += "  " + iterator.getValue().toString() + "\n";
            count++;
            iterator = iterator.getNext();
        }
        return salida;
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