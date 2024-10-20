class Compress {
    private String compress(String stringToCompress) {
        String compressedString = "";
        StringStorage myDictionary = new StringStorage();
        String searchWindow;

        for (int actualPosition = 0; actualPosition < stringToCompress.length(); actualPosition++) {
            int windowLength = 1;
            searchWindow = stringToCompress.substring(actualPosition, actualPosition + windowLength);
            System.out.println(searchWindow);

            if (myDictionary.contains(searchWindow)) {
                int dictionaryIndex = 0;
                String lastCharacter = "";
                while (myDictionary.contains(searchWindow)) {
                    dictionaryIndex = myDictionary.findString(searchWindow);
                    windowLength++;
                    searchWindow = stringToCompress.substring(actualPosition, actualPosition + windowLength);
                    lastCharacter = searchWindow.substring(searchWindow.length() - 1);
                }
                myDictionary.addString(searchWindow);
                compressedString = compressedString + "(" + dictionaryIndex + "," + lastCharacter + ")";
                actualPosition = actualPosition + searchWindow.length() - 1;
            } else {
                myDictionary.addString(searchWindow);
                compressedString = compressedString + "(0," + searchWindow + ")";
            }
            System.out.println(actualPosition + " - " + compressedString);
            myDictionary.showContents();
            System.out.println("=".repeat(20));
        }
        return compressedString;
    }
    public static void main(String[] args) {
        String respuesta = new Compress().compress("abababc");
        System.out.println(respuesta);
    }
}
