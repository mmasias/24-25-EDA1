public class App {
    public Cancion actual;
    public Canciones canciones = new Canciones();
    
    Cancion currentSong;
    List canciones = new List();
    public App(){
        new Menu(actual, canciones);
        new Menu(currentSong, canciones);
        String[][] cancionesIniciales = {
            {"Bryant Myers ft. Anonimus, Anuel AA y Almighty - Esclava Remix", "Bryant Myers", "285"},
            {"De La Ghetto, Arcángel, Ozuna, Anuel AA - La Ocasión", "De La Ghetto", "240"},
            {"Bad Bunny - Soy Peor", "Bad Bunny", "210"},
            {"Nio Garcia, Casper Magico, Bad Bunny, Ozuna, Nicky Jam - Te Boté Remix", "Nio Garcia", "435"},
            {"Natti Natasha x Ozuna - Criminal", "Natti Natasha", "216"},
            {"Bryant Myers - Dile (Remix) ft. Bad Bunny, Ozuna, Farruko, Arcángel", "Bryant Myers", "298"},
            {"Chris Jeday - Ahora Dice ft. J Balvin, Ozuna, Arcángel", "Chris Jeday", "300"},
            {"Yandel, Ozuna - No Quiero Amarte", "Yandel", "205"},
            {"Ozuna, Cardi B - La Modelo", "Ozuna", "231"},
            {"Bad Bunny, Prince Royce, J Balvin - Sensualidad", "Bad Bunny", "280"}
        };
        for (String[] datos : cancionesIniciales) {
            Cancion cancion = new Cancion(datos[0], datos[1], Integer.parseInt(datos[2]));
            canciones.insertEnd(cancion);
        }
    }