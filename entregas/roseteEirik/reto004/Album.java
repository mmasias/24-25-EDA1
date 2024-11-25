package entregas.roseteEirik.reto004;

class Album {
    private String title;
    private String author;
    private int year;
    
    public Album(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return this.title + " - " + this.author + " (" + this.year + ")";
    }
}