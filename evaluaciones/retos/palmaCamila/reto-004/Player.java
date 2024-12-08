public class Player {
    private Song currentSong;
    private Queue playQueue;
    private Stack history;
    private boolean shuffle;
    private boolean repeat;

    public Player() {
        this.currentSong = null;
        this.playQueue = new Queue();
        this.history = new Stack();
        this.shuffle = false;
        this.repeat = false;
    }

    public void play(PlayList playlist) {
        Song[] songs = playlist.getSongs();
        for (int i = 0; i < songs.length; i++) {
            playQueue.enqueue(songs[i]);
        }
        next();
    }

    public void next() {
        if (repeat) {
            return;
        }
        if (playQueue.isEmpty()) {
            return;
        }
        if (shuffle) {

        } else {
            if (currentSong != null) {
                history.push(currentSong);
            }
            currentSong = playQueue.dequeue();
        }
    }

    public void previous() {
        if (!history.isEmpty()) {
            playQueue.enqueue(currentSong);
            currentSong = history.pop();
        }
    }

    public void toggleShuffle() {
        shuffle = !shuffle;
    }

    public void toggleRepeat() {
        repeat = !repeat;
    }

    public boolean isPlaying() {
        return currentSong != null;
    }

    public String listQueue() {
        String data = "Cola de reproducción:\n";
        data += playQueue.toString();
        return data;
    }

    public String listHistory() {
        String data = "Historial:\n";
        data += history.toString();
        return data;
    }

    @Override
    public String toString() {
        return "Reproduciendo: " + (currentSong != null ? currentSong.toString() : "<Nada>") +
                "\nCola de reproducción: " + playQueue.toString() +
                "\nHistorial: " + history.toString() +
                "\nAleatorio: " + (shuffle ? "ON" : "OFF") +
                "\nRepetir: " + (repeat ? "ON" : "OFF");
    }
}
