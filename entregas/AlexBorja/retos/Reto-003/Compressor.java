class Compressor {
   private String lastKnownSequence = "";
   private Dictionary dictionary = new Dictionary();

   public String compress(String str) {
      String compressed = "";
      for (int i = 0; i < str.length(); i++) {
         String currenSequence = String.valueOf(str.charAt(i));

         if (lastKnownSequence.length() > 0) {
            String newMatch = lastKnownSequence + currenSequence;
            if (dictionary.isOnDictionary(newMatch)) {
               lastKnownSequence += currenSequence;
               continue;
            } else {
               dictionary.addToDictionary(newMatch);
               int idx = dictionary.getIndexOfSequence(lastKnownSequence);
               compressed += "(" + idx + "," + currenSequence + ") ";
               lastKnownSequence = "";
               continue;
            }
         }

         if (dictionary.isOnDictionary(currenSequence)) {
            lastKnownSequence = currenSequence;
            continue;
         } else {
            dictionary.addToDictionary(currenSequence);
            compressed += "(0," + currenSequence + ") ";
         }
      }

      return compressed;
   }

   public Dictionary getDictionary() {
      return dictionary;
   }
}
