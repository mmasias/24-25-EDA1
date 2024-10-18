public class Compressor {

    public String zip(String toZip) {
        String zip = "";
        Dictionary dictionary = new Dictionary();
        char actualChar;
        String actualSegment = "";
        int lastIndex = 0;
        for (int i = 0; i < toZip.length(); i++) {
            actualChar = toZip.charAt(i);
            actualSegment += actualChar;
            int index = dictionary.getSegmentIndex(actualSegment);
            if (index == 0) {
                dictionary.addElement(actualSegment);
                String compressedSegment = generateSegment(lastIndex, actualChar);
                zip += compressedSegment;
                actualSegment = "";
                lastIndex = 0;
            } else {
                lastIndex = index;
            }
        }
        return zip;
    }

    private String generateSegment(int index, char actualChar) {
        return "(" + index + "," + actualChar + ")";
    }

    public String unzip(String zipped) {
        String unzip = "";
        Dictionary dictionary = new Dictionary();
        while (!zipped.isEmpty()) {
            String segment = "";
            int index = getNextIndex(zipped);
            char lastCharacter = getNextCharacter(zipped);
            zipped = deleteFirstSegment(zipped);
            if (index != 0) {
                segment = dictionary.getSegmentAt(index);
            }
            segment += lastCharacter;
            unzip += segment;
            dictionary.addElement(segment);
        }
        return unzip;
    }

    private String deleteFirstSegment(String zipped) {
        return zipped.substring(zipped.indexOf(")")+1);
    }

    private char getNextCharacter(String zipped) {
        return zipped.charAt(zipped.indexOf(",")+1);
    }

    private int getNextIndex(String zipped) {
        return Integer.valueOf(zipped.substring(zipped.indexOf("(")+1, zipped.indexOf(",")));
    }
}
