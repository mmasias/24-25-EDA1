package entregas.Entrega_004;

public class Song {
    public String titulo;
    public String artista;
    public int duracion;    
    public boolean favorita;
    public String value;
    public Song next;
    public Song previous;
    
    public Song(String titulo, String artista, int duracion, String value) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = false;
        this.value= value;
        this.next = null;
        this.previous = null;
    }    

    public String toString(){
        return titulo + " - " + artista + " [" + duracion + "s]";
    }


public boolean isFavorita() {
    return favorita;
}

public void marcarFavorita() {
    this.favorita = true;
}

public void desmarcarFavorita() {
    this.favorita = false;
}


public Song getNext() {
    return next;
}



public void setNext(Song newSong) {
    this.next = next;
}



public String getValue() {
    return value;
}

public void setPrevious(Song last) {
   this.previous = previous;
}

public Song getPrevious() {
    return previous;
}

}