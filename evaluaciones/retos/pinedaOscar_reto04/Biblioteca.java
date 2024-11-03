package evaluaciones.retos.pinedaOscar_reto04;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Playlist> playlists;
    private ListaCanciones cancionesFavoritas;

    public Biblioteca() {
        playlists = new ArrayList<>();
        cancionesFavoritas = new ListaCanciones();
    }

    public void crearPlaylist(String nombre) {
        playlists.add(new Playlist(nombre));
        System.out.println("Playlist \"" + nombre + "\" creada con éxito.");
    }

    public void agregarCancionAPlaylist(String nombrePlaylist, Cancion cancion) {
        for (Playlist playlist : playlists) {
            if (playlist.getNombre().equals(nombrePlaylist)) {
                playlist.agregarCancion(cancion);
                System.out.println("Canción \"" + cancion.getTitulo() + "\" añadida a la playlist " + nombrePlaylist);
                return;
            }
        }
        System.out.println("Playlist no encontrada.");
    }

    public void mostrarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No hay playlists creadas.");
        } else {
            System.out.println("Playlists disponibles:");
            for (int i = 0; i < playlists.size(); i++) {
                System.out.println((i + 1) + ". " + playlists.get(i).getNombre());
            }
        }
    }

    public void mostrarCancionesDePlaylist(String nombrePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNombre().equals(nombrePlaylist)) {
                playlist.mostrarCanciones();
                return;
            }
        }
        System.out.println("Playlist no encontrada.");
    }

    public void agregarCancionAFavoritos(Cancion cancion) {
        cancionesFavoritas.agregarCancion(cancion);
        System.out.println("Canción \"" + cancion.getTitulo() + "\" añadida a favoritos.");
    }

    public void mostrarCancionesFavoritas() {
        System.out.println("Canciones favoritas:");
        cancionesFavoritas.mostrarLista();
    }
}