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

    public void changeStarred(){
        this.starred = !this.starred;
    }

    public boolean isStarred(){
        return this.starred;
    }

    public String toString(){
        return this.title + " - " + this.author + " (" + this.length + "s)";
    }
}