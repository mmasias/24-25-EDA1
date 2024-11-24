public class Dictionary {
    private String[] dictionary;
    private int lastPosition = 0;

    public Dictionary(int size) {
        this.dictionary = new String[size];
    }

    public int getTextPosition(String text) {
        for (int i = 0; i < lastPosition; i++) {
            if (dictionary[i].equals(text)) {
                return i + 1;
            }
        }
        return 0;
    }

    public String getPositionText(int position) {
        if (position == 0) {
            return "";
        }
        return dictionary[position - 1];
    }

    public void append(String text) {
        dictionary[lastPosition] = text;
        lastPosition++;
    }

    public String[] getDictionary() {
        return dictionary;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < lastPosition; i++) {
            result += "(" + (i + 1) + "," + dictionary[i] + ")";
        }
        return result;
    }
}
