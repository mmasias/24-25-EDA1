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
            }
            {
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

      String dic = dictionary.getDictionary();
      return compressed + "\n" + dic;
   }
}

// EXPECTEC OUTPUT:
// (0,a) (0,b) (1,0) (3,c) (2,d) (0,c)
// 1:a 2:b 3:ab 4:abc 5: bd 6: c
