public class Dictionary {
    private DictionaryElement[] dictionary;
    

    public Dictionary() {
        dictionary=new DictionaryElement[0];
    }

    public int getSegmentIndex(String actualSegment) {
        if (dictionary.length==0) return 0;
        for (DictionaryElement dictionaryElement : dictionary) {
            if (dictionaryElement.getElement().equals(actualSegment)) {
                return dictionaryElement.getIndex();
            }
        }
        return 0;
    }
    


    public void addElement(String actualSegment) {
        if (dictionary.length == 0) {
            dictionary = new DictionaryElement[1];
            dictionary[0] = new DictionaryElement(1, actualSegment);
        } else {
            int index = dictionary[dictionary.length - 1].getIndex();
            DictionaryElement[] aux = new DictionaryElement[dictionary.length + 1];
            for (int i = 0; i < dictionary.length; i++) {
                aux[i] = dictionary[i];
            }
            aux[aux.length - 1] = new DictionaryElement(index + 1, actualSegment);
            dictionary=aux;
        }
    }

}
