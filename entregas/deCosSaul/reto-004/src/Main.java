public class Main {
    public static void main(String[] args) {
        Album album = new Album("Hybrid Theory", "Linkin Park", 2000);
        Cancion cancion = new Cancion("Papercut", "Linkin Park", 300);
        album.anadirCancion(cancion);
        System.out.println(album.toString());
        cancion.favorita();
        cancion.enFavoritos();
        cancion.favorita();
        cancion.enFavoritos();

    }
}
