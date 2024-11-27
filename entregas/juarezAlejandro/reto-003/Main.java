class Main {
   public static void main(String[] args) {
      String texto = "abababcbdc";
      Compresor compresor = new Compresor();
      String comprimir = compresor.comprimir(texto);
      System.out.println("Texto comprimido" + comprimir);

      Descompresor descompresor = new Descompresor();
      String descomprimido = descompresor.descomprimir(comprimir, compresor.getDiccionario());
      System.out.println("Texto descomprimido" + descompresor);
   }
}