class Main {
   public static void main(String[] args) {
      List myList = new List();
      myList.insertEnd("A");
      myList.insertEnd("B");
      myList.insertEnd("C");

      String[] list = myList.listAll();
      printList(list);

      ListResponse response = myList.find("A");
      printList(response.listAll());

      list = myList.listAll();
      printList(list);
   }

   public static void printList(String[] list) {
      for(int i = 0; i < list.length; i++) {
         System.out.print("" + list[i] + " ");
      }
      System.out.println();
   }
}
