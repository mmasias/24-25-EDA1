package entregas.lopesBrenda.reto004;

import java.util.LinkedList;

public class BibliotecaMusical {
    private LinkedList<Album> albumes;
    private LinkedList<Playlist> playlists;
    private LinkedList<Cancion> favoritos;

    public BibliotecaMusical() {
        this.albumes = new LinkedList<>();
        this.playlists = new LinkedList<>();
        this.favoritos = new LinkedList<>();
    }

    public void agregarAlbum(Album album) {
        albumes.add(album);
    }

    public Playlist crearPlaylist(String nombre) {
        Playlist playlist = new Playlist(nombre);
        playlists.add(playlist);
        return playlist;
    }

    public void agregarAFavoritos(Cancion cancion) {
        favoritos.add(cancion);
    }

    public LinkedList<Playlist> getPlaylists() {
        return playlists;
    }

    public LinkedList<Cancion> getFavoritos() {
        return favoritos;
    }

    public LinkedList<Album> getAlbumes() {
        return albumes;
    }
}
