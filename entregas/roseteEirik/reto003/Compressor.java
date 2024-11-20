package entregas.roseteEirik.reto003;

class Compressor {

    private String stringToConvert;

    public Compressor(String string) {
        string = this.stringToConvert;
        ComDictionary dictionary = new ComDictionary();
        compressString(string, dictionary);
    }

    private void compressString(String string, ComDictionary dictionary) {

        String searchWindow = null;

        for (int position = 0; position != string.length(); position++) {
            searchWindow = searchWindow + string.charAt(position);
            if (!dictionary.coincidence(searchWindow)){
                dictionary.update(searchWindow);
                searchWindow = null;
            }
        }
    }
}