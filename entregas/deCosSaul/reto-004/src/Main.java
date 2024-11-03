public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();
        Album album = new Album("Hybrid Theory", "Linkin Park", 2000);
        Cancion cancion = new Cancion("Papercut", "Linkin Park", 300);
        Cancion cancion2 = new Cancion("Papercut2", "Linkin Park", 300);
        Cancion cancion3 = new Cancion("Papercut3", "Linkin Park", 300);
        Cancion cancion4 = new Cancion("Papercut4", "Linkin Park", 300);
        

        biblioteca.verCancionesFavoritas();
        biblioteca.anadirAFavoritos(cancion);
        biblioteca.anadirAFavoritos(cancion2);
        biblioteca.anadirAFavoritos(cancion3);
        biblioteca.anadirAFavoritos(cancion4);
        biblioteca.verCancionesFavoritas();
        biblioteca.eliminarDeFavoritos(cancion);
        biblioteca.verCancionesFavoritas();
        biblioteca.crearPlaylist("Hybrid Theory");
        biblioteca.crearPlaylist("Hybrid Theory 2");
        biblioteca.verPlaylists();
        biblioteca.anadirCancionAPlaylist(0, cancion);
        biblioteca.anadirCancionAPlaylist(0, cancion2);
        biblioteca.anadirCancionAPlaylist(0, cancion3);
        biblioteca.anadirCancionAPlaylist(0, cancion4);
        biblioteca.anadirCancionAPlaylist(1, cancion3);
        biblioteca.anadirCancionAPlaylist(1, cancion4);
        biblioteca.verPlaylists();
        biblioteca.eliminarCancionDePlaylist(0, 4-1);
        biblioteca.verPlaylists();
        reproductor.seleccionarPlaylist(biblioteca.seleccionarPlaylistParaReproduccion(0));
        reproductor.activarModoAleatorio();
        reproductor.reproducirCancionActual();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.cancionAnterior();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.siguienteCancion();
        reproductor.verColaDeReproduccion();
        reproductor.mostrarHistorial();


    }
}
