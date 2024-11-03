public class App {

    Cancion currentSong;
    List canciones = new List();

    public App(){
        String[][] cancionesIniciales = {
            {"Anuel AA - Ella Quiere Beber", "Anuel AA", "207"},
            {"Anuel AA - Bebe", "Anuel AA", "201"},
            {"Anuel AA - Keii", "Anuel AA", "218"},
            {"Anuel AA - Secreto", "Anuel AA", "190"},
            {"Anuel AA ft. Bad Bunny - Hasta Que Dios Diga", "Anuel AA", "245"},
            {"JCreyes - Te Extraño", "JCreyes", "192"},
            {"JCreyes - Sin Miedo", "JCreyes", "210"},
            {"JCreyes - Volver a Verte", "JCreyes", "223"},
            {"Anuel AA - Reggaetonera", "Anuel AA", "225"},
            {"JCreyes - Solo Mía", "JCreyes", "230"}
        };
        for (String[] datos : cancionesIniciales) {
            Cancion cancion = new Cancion(datos[0], datos[1], Integer.parseInt(datos[2]));
            canciones.insertEnd(cancion);
        }
        new Menu(currentSong, canciones);
    }
    public static void main(String[] args) {
        new App();
    }
}
