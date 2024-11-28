public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();

        Cancion c1 = new Cancion("Sicko Mode", "Travis Scott", 300);
        Cancion c2 = new Cancion("God's Plan", "Drake", 198);
        Cancion c3 = new Cancion("HUMBLE.", "Kendrick Lamar", 177);

        biblioteca.agregarCancionAFavoritos(c1);
        biblioteca.agregarCancionAFavoritos(c2);

        biblioteca.crearPlaylist("Rap Hits");
        biblioteca.agregarCancionAPlaylist("Rap Hits", c1);
        biblioteca.agregarCancionAPlaylist("Rap Hits", c3);

        biblioteca.mostrarPlaylists();
        biblioteca.mostrarCancionesFavoritas();

        reproductor.agregarCancionACola(c1);
        reproductor.agregarCancionACola(c2);
        reproductor.reproducirSiguiente();
        reproductor.verColaReproduccion();
        reproductor.verHistorial();
    }
}
