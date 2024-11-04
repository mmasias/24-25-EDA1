public class List {

   private Node first = null;
   private int size = 0;

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size() > 0 ? false : true;
   }

   public void insertEnd(String value) {
      Node newNode = new Node(value);
      if (this.first == null) {
         this.first = newNode;
         size++;
      } else {
         Node iterator = this.first;
         while (iterator.getNext() != null) {
            iterator = iterator.getNext();
         }
         iterator.setNext(newNode);
         size++;
      }
   }

   public void insertFront(String value) {
      Node n = new Node(value);
      if (this.first == null) {
         this.first = n;
         size++;
      } else {
         n.setNext(this.first);
         this.first = n;
         size++;
      }
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
         size--;
      }
   }

   public void deleteFront() {
      if (this.first != null) {
         this.first = this.first.getNext();
         size--;
      }
   }

   public Node[] find(String value) {
      Node iterator = this.first;
      Node[] nodes = new Node[this.size()];
      int count = 0;
      while (iterator != null) {
         if (iterator.getValue().equals(value)) {
            nodes[count] = iterator;
            count++;
         }
         iterator = iterator.getNext();
      }
      return nodes;
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
