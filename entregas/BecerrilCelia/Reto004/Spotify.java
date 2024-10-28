package Reto004;

public class Spotify {
    

    public static void main(String[] args) {
        Album album = new Album("Album 1", "Artista 1", 2024);

        album.agregarCancion(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        album.agregarCancion(new Cancion("Los Dinosaurios", "Charly García", 234));
        album.agregarCancion(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        album.agregarCancion(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        album.agregarCancion(new Cancion("No Soy Un Extraño", "Charly García", 295));
        album.agregarCancion(new Cancion("Seminare", "Serú Girán", 238));
        album.agregarCancion(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        album.agregarCancion(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        album.agregarCancion(new Cancion("Película sordomuda", "Charly García", 235));
        album.agregarCancion(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));

        System.out.println(album);
    }
}
