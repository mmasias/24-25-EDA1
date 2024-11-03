package entregas.grizoniManuela.reto004;

class Playlist {
    private String name;
    private Cancion[] songs;
    private int size;
    private int capacity;

    public Playlist(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.songs = new Cancion[capacity];
        
    }
    
}
