package entregas.roseteEirik.reto004;

class Song {
    private String title;
    private String author;
    private int length;    
    private boolean starred;
    
    public Song(String title, String author, int length) {
        this.title = title;
        this.author = author;
        this.length = length;
        this.starred = false;
    }

    public void starred(){
        this.starred = true;
    }

    public void unstarred(){
        this.starred = false;
    }

    public String toString(){
        
    }
}