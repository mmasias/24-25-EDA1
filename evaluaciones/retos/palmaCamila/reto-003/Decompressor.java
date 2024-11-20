
public class Decompressor {
    public String decompress(String compressed, Dictionary dictionary) {
        String decompressed = "";

        for (int i = 0; i < compressed.length(); i++) {
            if (compressed.charAt(i) == '(') {
                int commaIndex = compressed.indexOf(',', i);
                int closeParenthesisIndex = compressed.indexOf(')', i);

                int index = Integer.parseInt(compressed.substring(i + 1, commaIndex));
                String character = compressed.substring(commaIndex + 1, closeParenthesisIndex);

                decompressed += dictionary.getPositionText(index) + character;
                i = closeParenthesisIndex;
            }
        }

        return decompressed;
    }
}