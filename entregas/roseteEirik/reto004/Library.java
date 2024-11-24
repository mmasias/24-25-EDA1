package entregas.roseteEirik.reto004;

public class Library {
    private Song[] songs;
    private Album[] albums;
    public static Library instance;
    private int songCount;
    private int albumCount;

    public Library() {
        this.songs = new Song[100];
        this.albums = new Album[100];
        this.songCount = 0;
        this.albumCount = 0;
    }

    public static Library getInstance(){
        if (instance == null){
            instance = new Library();
        }
        return instance;
    }

    public void addSong(Song song) {
        this.songs[this.songCount] = song;
        this.songCount++;
    }

    public void addAlbum(Album album) {
        this.albums[this.albumCount] = album;
        this.albumCount++;
    }

    public void listSongs() {
        for (int i = 0; i < this.songCount; i++) {
            System.out.println(this.songs[i]);
        }
    }

    public void listAlbums() {
        for (int i = 0; i < this.albumCount; i++) {
            System.out.println(this.albums[i]);
        }
    }

    public void listStarredSongs() {
        for (int i = 0; i < this.songCount; i++) {
            if (this.songs[i].isStarred()) {
                System.out.println(this.songs[i]);
            }
        }
    }

    public void starSong(int index) {
        if (!this.songs[index].isStarred()) {
            this.songs[index].changeStarred();
        }
    }

    public void unstarSong(int index) {
        if (this.songs[index].isStarred()) {
            this.songs[index].changeStarred();
        }
    }
}
