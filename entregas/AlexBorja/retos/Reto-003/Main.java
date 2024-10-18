class Main {
   public static void main(String[] args) {
      String str = "abababcbdc";
      Compressor compressor = new Compressor();
      String compressed = compressor.compress(str);
      System.out.println(compressed);
   }
}
