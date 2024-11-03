package evaluaciones.retos.pinedaOscar_reto04;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Reproductor reproductor = new Reproductor();

        Cancion c1 = new Cancion("Best Interest", "Tyler the Creator", 124);
        Cancion c2 = new Cancion("X19X", "Feid", 144);
        Cancion c3 = new Cancion("Te Necesito", "Luis Miguel", 188);

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