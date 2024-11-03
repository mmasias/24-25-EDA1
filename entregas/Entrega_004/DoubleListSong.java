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
        String result = "";  // Inicializamos una cadena vacía
        Song iterator = first;
        
        while (iterator != null) {
            result += iterator.toString() + "\n";  // Concatenamos cada canción y un salto de línea
            iterator = iterator.getNext();  // Avanzamos al siguiente nodo
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
}