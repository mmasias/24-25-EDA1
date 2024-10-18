class Main {
   public static void main(String[] args) {
      String str = "abababcd3f3fxx";
      Compressor compressor = new Compressor();
      String compressed = compressor.compress(str);
      System.out.println(compressed);

      Decompressor decompressor = new Decompressor();
      String decompressed = decompressor.decompress(compressed, compressor.getDictionary());
      System.out.println(decompressed);
   }
}
