class Main {
   public static void main(String[] args) {
      String texto = "abababcbdc";
      Compresor compresor = new Compresor();
      String comprimir = compresor.comprimir(texto);
      System.out.println(comprimir);
   }
}