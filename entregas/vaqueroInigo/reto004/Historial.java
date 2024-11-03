package entregas.vaqueroInigo.reto004;

import java.util.LinkedList;

public class Historial {
    private LinkedList<Cancion> historial;

    public Historial() {
        historial = new LinkedList<>();
    }

    public void agregarCancion(Cancion cancion) {
        historial.add(cancion);
    }

    public void mostrarHistorial() {
        for (Cancion cancion : historial) {
            System.out.println(cancion);
        }
    }
}
