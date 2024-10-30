public class Spotify {
    public static void main(String[] args) {
        Cancion cancion1 = new Cancion("titulo1", "artista1", 230);
        Cancion cancion2 = new Cancion("titulo2", "artista1", 220);
        Cancion cancion3 = new Cancion("titulo3", "artista1", 210);
        Cancion cancion4 = new Cancion("titulo4", "artista1", 200);
        Cancion cancion5 = new Cancion("titulo5", "artista1", 190);
        Cancion cancion6 = new Cancion("titulo6", "artista1", 180);
        Album album1 = new Album("tituloAlbum", "artista1", 2003);
        System.out.println(cancion1.toString());
        System.out.println(cancion2.toString());
        System.out.println(cancion3.toString());
        System.out.println(cancion4.toString());
        System.out.println(cancion5.toString());
        System.out.println(cancion6.toString());
        album1.anadirCancion(cancion1);
        album1.anadirCancion(cancion2);
        album1.anadirCancion(cancion3);
        album1.anadirCancion(cancion4);
        album1.anadirCancion(cancion5);
        album1.anadirCancion(cancion6);
        System.out.println("=".repeat(30));
        album1.mostrarAlbum();
    }
}
