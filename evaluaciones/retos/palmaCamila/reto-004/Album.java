class Album {
    private String title;
    private String artist;
    private int year;

    public Album(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public String toString() {
        return title + " - " + artist + " (" + year + ")";
    }

}