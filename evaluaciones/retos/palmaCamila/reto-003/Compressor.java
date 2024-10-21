
public class Compressor {
    private Dictionary dictionary;

    public String compress(String sequence) {
        this.dictionary = new Dictionary(sequence.length());

        String compressed = "";
        int lastPosition = 0;
        int lastFoundIndex = 0;

        for (int i = 0; i < sequence.length(); i++) {
            String current = sequence.substring(lastPosition, i + 1);
            System.out.println(current);

            int currentPosition = dictionary.getTextPosition(current);
            if (currentPosition == 0) {
                dictionary.append(current);
                System.out.println("no está, añadir: " + current);
                if (lastFoundIndex != 0) {
                    System.out.println(
                            "como no está, añadiremos el último que hemos encontrado en esta secuencia : " + current);

                    compressed += "(" + lastFoundIndex + "," + sequence.substring(i, i + 1) + ")";
                    lastFoundIndex = 0;
                } else {
                    compressed += "(0," + current + ")";
                }

                System.out.println("Comprimido:" + compressed);
                lastPosition = i + 1;
            } else {
                System.out.println("Si está en " + currentPosition + " " + current);
                lastFoundIndex = currentPosition;
                System.out.println("lastFoundIndex: " + lastFoundIndex);
                System.out.println("Comprimido:" + compressed);
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