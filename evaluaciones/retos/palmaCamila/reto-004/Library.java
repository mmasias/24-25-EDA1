class Library {
    private SongsLinkedList availableSongs;
    private PlayList favourites;
    private PlayListLinkedList userPlayLists;

    public Library() {
        this.availableSongs = new SongsLinkedList();
        this.favourites = new PlayList("Favoritas");
        this.userPlayLists = new PlayListLinkedList();
    }

    public void addSong(Song song) {
        availableSongs.addSong(song);
    }

    public void removeSong(int index) {
        availableSongs.removeSong(index);
    }

    public Song getSong(int index) {
        return availableSongs.get(index);
    }

    public Song[] getAllSongs() {
        return availableSongs.listAll();
    }

    public void addPlayList(String name) {
        userPlayLists.addPlayList(new PlayList(name));
    }

    public void removePlayList(int index) {
        userPlayLists.removePlayList(index);
    }

    public PlayList getPlayList(int index) {
        return userPlayLists.get(index);
    }

    public PlayList getFavourites() {
        return this.favourites;
    }

    public boolean hasUserPlayLists() {
        return userPlayLists.size() > 0;
    }

    public String listAvailableSongs() {
        return availableSongs.toString();
    }

    public String listFavourites() {
        return favourites.toString();
    }

    public String listUserPlayLists() {
        String data = "";
        for (int i = 0; i < userPlayLists.size(); i++) {
            data += i + ". " + userPlayLists.get(i).getName() + "\n";
        }
        return data;
    }

    @Override
    public String toString() {
        String data = "";
        data += availableSongs.toString();
        data += favourites.toString();
        data += userPlayLists.toString();
        return data;
    }
}