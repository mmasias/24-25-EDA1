class Cliente {
   private int items;

   public Cliente() {
      this.items = generarItemsIniciales();
   }

   private int generarItemsIniciales() {
      return (int) (Math.random() * 10) + 1;
   }

   public void agregarItems(int item, int clientIdx) {
      this.items += item;
      System.out.println("Agregado " + item + " ítems al cliente " + clientIdx);
   }

   public void imprimirCliente() {
      System.out.println(" Ítems: " + this.items);
   }
}
