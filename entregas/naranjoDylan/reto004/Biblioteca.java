package entregas.naranjoDylan.reto004;

public class Biblioteca {
    private Lista canciones;

    public Biblioteca() {
        canciones = new Lista();
    }

    public void inicializar() {
        canciones.agregar(new Cancion("Demoliendo Hoteles", "Charly García", 258));
        canciones.agregar(new Cancion("Los Dinosaurios", "Charly García", 234));
        canciones.agregar(new Cancion("Rasguña Las Piedras", "Sui Generis", 285));
        canciones.agregar(new Cancion("Canción Para Mi Muerte", "Sui Generis", 342));
        canciones.agregar(new Cancion("No Soy Un Extraño", "Charly García", 295));
        canciones.agregar(new Cancion("Seminare", "Serú Girán", 238));
        canciones.agregar(new Cancion("Promesas Sobre El Bidet", "Charly García", 243));
        canciones.agregar(new Cancion("Rezo Por Vos", "Charly García & Luis Alberto Spinetta", 266));
        canciones.agregar(new Cancion("Película sordomuda", "Charly García", 235));
        canciones.agregar(new Cancion("¿Qué se puede hacer salvo ver películas?", "La máquina de hacer pájaros", 325));
    }

    public Lista getCanciones() {
        return canciones;
    }
}
