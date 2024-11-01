public class Canciones {

    List todasLasCanciones = new List();

    public Canciones() {
        String[][] cancionesIniciales = {
            {"Anuel AA - Sola", "Anuel AA", "220"},
            {"Anuel AA - Secreto ft. Karol G", "Anuel AA", "260"},
            {"Anuel AA - Hipócrita", "Anuel AA", "215"},
            {"JC Reyes - La 40", "JC Reyes", "230"},
            {"JC Reyes - Hablamos Mañana", "JC Reyes", "205"},
            {"Anuel AA - China ft. Daddy Yankee, Karol G, Ozuna, J Balvin", "Anuel AA", "295"},
            {"Anuel AA - Keii", "Anuel AA", "230"},
            {"JC Reyes - La Calle Me Llama", "JC Reyes", "210"},
            {"Anuel AA - Ella Quiere Beber ft. Romeo Santos", "Anuel AA", "250"},
            {"JC Reyes - Vida Mala", "JC Reyes", "225"}
        };

        for (String[] datos : cancionesIniciales) {
            Cancion cancion = new Cancion(datos[0], datos[1], Integer.parseInt(datos[2]));
            todasLasCanciones.insertEnd(cancion);
        }
    }

    public List todasLasCanciones(){
        return todasLasCanciones;
    }
}
