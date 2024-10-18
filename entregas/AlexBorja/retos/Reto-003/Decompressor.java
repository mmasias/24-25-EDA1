class Decompressor {
   private final int INDEX_POSITION = 1;;
   private final int CHAR_POSITION = 3;

   public String decompress(String compressed, Dictionary dictionary) {
      String[] elements = compressed.split(" ");
      String output = "";
      for (int i = 0; i < elements.length; i++) {
         String element = elements[i];
         int index = Integer.parseInt(String.valueOf(element.charAt(INDEX_POSITION)));
         String character = String.valueOf(element.charAt(CHAR_POSITION));
         if (index == 0) {
            output += character;
         } else {
            output += dictionary.getSequenceByIndex(index) + character;
         } 
      }
      return output;
   }
}
