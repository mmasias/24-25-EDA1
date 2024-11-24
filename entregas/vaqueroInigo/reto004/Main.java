package entregas.vaqueroInigo.reto004;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarCancion(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        biblioteca.agregarCancion(new Cancion("Los Dinosaurios", "Charly García", 234));
        biblioteca.agregarCancion(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        biblioteca.agregarCancion(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        biblioteca.agregarCancion(new Cancion("No Soy Un Extraño", "Charly García", 295));
        biblioteca.agregarCancion(new Cancion("Seminare", "Serú Girán", 238));
        biblioteca.agregarCancion(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        biblioteca.agregarCancion(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        biblioteca.agregarCancion(new Cancion("Película sordomuda", "Charly García", 235));
        biblioteca.agregarCancion(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));

        Reproductor reproductor = new Reproductor(biblioteca);
        reproductor.iniciar();
    }
}
