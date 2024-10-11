public class ListResponse {

   private NodeWrapper first = null;
   private int size = 0;

   public int size() {
      return this.size;
   }

   public boolean isEmpty() {
      return this.size() > 0 ? false : true;
   }

   public void insertEnd(Node value) {
      NodeWrapper newNode = new NodeWrapper(value);
      if (this.first == null) {
         this.first = newNode;
         size++;
      } else {
         NodeWrapper iterator = this.first;
         while (iterator.getNext() != null) {
            iterator = iterator.getNext();
         }
         iterator.setNext(newNode);
         size++;
      }
   }

   public void insertFront(NodeWrapper value) {
      NodeWrapper n = new NodeWrapper(value);
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
         NodeWrapper iterator = this.first;
         NodeWrapper previous = null;
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

   public String[] listAll() {
      String[] list = new String[this.size()];
      NodeWrapper iterator = this.first;
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
