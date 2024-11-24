package entregas.roseteEirik.reto004;

public class MusicPlayer {

    private Song[] songs;
    private Song[] historySongs;
    private boolean random;
    private boolean repeat;
    
    public MusicPlayer() {
        this.songs = new Song[100];
        this.historySongs = new Song[100];
        this.random = false;
        this.repeat = false;
    }

    public Song getCurrentSong(){
        return this.songs[0];
    }

    public void playNext(){
        this.historySongs[0] = this.songs[0];
        this.songs[0] = this.songs[1];
    }

    public void play(){
        this.historySongs[0] = this.songs[0];
    }



}