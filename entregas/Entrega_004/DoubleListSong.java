public class DoubleListSong {
    private Song first;
    private Song last;
    public int size;

    public DoubleListSong() {
        this.first = null;
        this.last = null;
        this.size=0;
    }

    public void insertEnd(Song newSong) {
        if (first == null) {
            first = newSong;
            last = newSong;
        } else {
            last.setNext(newSong);
            newSong.setPrevious(last);
            last = newSong;
        }
        size++;
    }

    public void deleteEnd() {
        if (last == null) {
            return;
        }
        
        if (first == last) {
            first = null;
            last = null;
        } else {

            last = last.getPrevious();
            if (last != null) {
                last.setNext(null);
            }
        }
    }

    public Song getFirst(){
        return first;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String listAll() {
        String result = "";  
        Song iterator = first;
        
        while (iterator != null) {
            result += iterator.toString() + "\n";  
            iterator = iterator.getNext();  
        }
        
        return result;
    }

    public void inserEnd(Song newSong) {
        if (first == null) {
            first = newSong;
            last = newSong;
        } else {  
            last.setNext(newSong);       
            newSong.setPrevious(last);    
            last = newSong;               
        }
        size++;
    }
    public void showSongs() {
        Song iterator = first;
        System.out.println("Canciones en la biblioteca:");
        while(iterator != null){
            System.out.println(iterator);
            iterator = iterator.getNext;
        }
    }
}