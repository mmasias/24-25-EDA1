public class Compressor {

    public String zip(String toZip) {
        String zip="";
        Dictionary dictionary=new Dictionary();
        char actualChar;
        String actualSegment="";
        boolean isNewSegment=true;
        for (int i = 0; i < toZip.length(); i++) {
            actualChar=toZip.charAt(i);
            actualSegment+=actualChar;
            int index=dictionary.segmentIndex(actualSegment);
            if (index==0){
                dictionary.addElement(actualSegment);
                String compressedSegment=generateSegment(index,actualChar);
                actualSegment="";
            }else{
                String compressedSegment=generateSegment(index,actualChar);
                zip+=compressedSegment;
            }
        }
        return zip;
    }

    private String generateSegment(int index, char actualChar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateSegment'");
    }
}
