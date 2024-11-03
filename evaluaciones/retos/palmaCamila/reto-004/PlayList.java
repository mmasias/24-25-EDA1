class PlayList {
    private SongsLinkedList songs;
    private String name;

    public PlayList(String name) {
        this.songs = new SongsLinkedList();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addSong(Song song) {
        songs.addSong(song);
    }

    public void removeSong(int index) {
        songs.removeSong(index);
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    @Override
    public String toString() {
        String data = this.name + "\n";
        data += songs.toString();
        return data;
    }
}