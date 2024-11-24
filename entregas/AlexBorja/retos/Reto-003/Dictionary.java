class Dictionary {
   private String[] dictionary = new String[100];

   public int getIndexOfSequence(String sequence) {
      int idx = 0;
      while (dictionary[idx] != null) {
         if (dictionary[idx].equals(sequence)) {
            return idx + 1;
         }
         idx++;
      }
      return -1;
   }

   public void addToDictionary(String sequence) {
      for (int i = 0; i < dictionary.length; i++) {
         if (dictionary[i] == null) {
            dictionary[i] = sequence;
            break;
         }
      }
   }

   public boolean isOnDictionary(String sequence) {
      for (int i = 0; i < dictionary.length; i++) {
         if (dictionary[i] != null && dictionary[i].equals(sequence)) {
            return true;
         }
      }
      return false;
   }

   public String getDictionary() {
      String result = "";
      for (int i = 0; i < dictionary.length; i++) {
         if (dictionary[i] != null) {
            result += (i + 1) + ":" + dictionary[i] + " ";
         }
      }
      return result;
   }

   public String getSequenceByIndex(int idx) {
      return dictionary[idx - 1];
   }
}
