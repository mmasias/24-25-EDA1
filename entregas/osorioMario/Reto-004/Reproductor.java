import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reproductor {
    private Queue<Cancion> colaReproduccion;
    private Stack<Cancion> historial;

    public Reproductor() {
        this.colaReproduccion = new LinkedList<>();
        this.historial = new Stack<>();
    }

    public void agregarCancionACola(Cancion cancion) {
        colaReproduccion.add(cancion);
        System.out.println("Canción \"" + cancion.getTitulo() + "\" añadida a la cola de reproducción.");
    }

    public void reproducirSiguiente() {
        if (!colaReproduccion.isEmpty()) {
            Cancion cancionActual = colaReproduccion.poll();
            historial.push(cancionActual);
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    public void reproducirAnterior() {
        if (!historial.isEmpty()) {
            Cancion cancionAnterior = historial.pop();
            System.out.println("▶ Reproduciendo: " + cancionAnterior);
        } else {
            System.out.println("No hay canciones en el historial.");
        }
    }

    public void verColaReproduccion() {
        if (colaReproduccion.isEmpty()) {
            System.out.println("La cola de reproducción está vacía.");
        } else {
            System.out.println("Cola de reproducción:");
            for (Cancion cancion : colaReproduccion) {
                System.out.println("- " + cancion);
            }
        }
    }

    public void verHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("Historial de reproducción:");
            for (Cancion cancion : historial) {
                System.out.println("- " + cancion);
            }
        }
    }
}
