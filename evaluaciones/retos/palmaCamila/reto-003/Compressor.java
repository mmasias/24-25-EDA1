
public class Compressor {
    private Dictionary dictionary;

    public String compress(String sequence) {
        this.dictionary = new Dictionary(sequence.length());

        String compressed = "";
        int lastPosition = 0;
        int lastFoundIndex = 0;

        for (int i = 0; i < sequence.length(); i++) {
            String current = sequence.substring(lastPosition, i + 1);

            int currentPosition = dictionary.getTextPosition(current);
            if (currentPosition == 0) {
                dictionary.append(current);
                if (lastFoundIndex != 0) {
                    compressed += "(" + lastFoundIndex + "," + sequence.substring(i, i + 1) + ")";
                    lastFoundIndex = 0;
                } else {
                    compressed += "(0," + current + ")";
                }
                lastPosition = i + 1;
            } else {
                lastFoundIndex = currentPosition;
            }

        }

        return compressed;
    }

    public Dictionary getDictionary() {
        String[] internalDictionary = this.dictionary.getDictionary();
        Dictionary newDictionary = new Dictionary(internalDictionary.length);

        for (int i = 0; i < internalDictionary.length; i++) {
            if (internalDictionary[i] != null) {
                newDictionary.append(internalDictionary[i]);
            }
        }

        return newDictionary;
    }
}