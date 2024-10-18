public class Compressor {

    public String zip(String toZip) {
        String zip="";
        Dictionary dictionary=new Dictionary();
        char actualChar;
        String actualSegment="";
        int lastIndex=0;
        boolean isNewSegment=true;
        for (int i = 0; i < toZip.length(); i++) {
            actualChar=toZip.charAt(i);
            actualSegment+=actualChar;
            int index=dictionary.getSegmentIndex(actualSegment);
            if (index==0){
                dictionary.addElement(actualSegment);
                String compressedSegment=generateSegment(lastIndex,actualChar);
                zip+=compressedSegment;
                actualSegment="";
                lastIndex=0;
            }else{
                String compressedSegment=generateSegment(index,actualChar);
                lastIndex=index;
            }
        }
        return zip;
    }

    private String generateSegment(int index, char actualChar) {
        return "("+index+","+actualChar+")";
    }

    public String unzip(String zipped) {
        String unzip="";
        Dictionary dictionary=new Dictionary();
        while(!zipped.isEmpty()){
            int index=getNextIndex(zipped);
            char lastCharacter=getNextCharacter(zipped);
            zipped=deleteFirstSegment(zipped);
            if (index!=0){
                String segment=dictionary.getSegmentAt(index);
            }
        }
    }
}
