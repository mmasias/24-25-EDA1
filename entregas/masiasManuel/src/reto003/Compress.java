class Compress {
    public static void main(String[] args) {
        String respuesta = new Compress().compress("abababc");
        System.out.println(respuesta);
    }

    private String compress(String stringToCompress) {
        String compressedString = "";
        StringStorage myDictionary = new StringStorage();
        String searchWindow;

        for (int actualPosition = 0; actualPosition < stringToCompress.length(); actualPosition++) {
            int windowsLength = 1;
            searchWindow = stringToCompress.substring(actualPosition, actualPosition + windowsLength);
            System.out.println(searchWindow);

            if (myDictionary.contains(searchWindow)) {
                
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
}
