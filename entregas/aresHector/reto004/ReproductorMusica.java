import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReproductorMusica {
    private Queue<Cancion> colaReproduccion;
    private Stack<Cancion> historialReproduccion;
    private boolean modoAleatorio;
    private boolean modoRepeticion;
    public Cancion cancionActual;

    public ReproductorMusica() {
        this.colaReproduccion = new LinkedList<>();
        this.historialReproduccion = new Stack<>();
        this.modoAleatorio = false;
        this.modoRepeticion = false;
        this.cancionActual = null;
    }

    public void agregarCancionCola(Cancion cancion) {
        colaReproduccion.add(cancion);
    }

    public void reproducirSiguiente() {
        if (cancionActual != null) {
            historialReproduccion.push(cancionActual);
        }
        cancionActual = colaReproduccion.poll();
        if (cancionActual != null) {
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay más canciones en la cola de reproducción.");
        }
    }

    public void reproducirAnterior() {
        if (!historialReproduccion.isEmpty()) {
            colaReproduccion.add(cancionActual); // Devuelve la actual a la cola
            cancionActual = historialReproduccion.pop();
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay canciones anteriores en el historial.");
        }
    }

    public void activarDesactivarAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("Modo aleatorio: " + (modoAleatorio ? "Activado" : "Desactivado"));
    }

    public void activarDesactivarRepeticion() {
        modoRepeticion = !modoRepeticion;
        System.out.println("Modo repetición: " + (modoRepeticion ? "Activado" : "Desactivado"));
    }

    public void verColaReproduccion() {
        System.out.println("COLA DE REPRODUCCIÓN:");
        for (Cancion cancion : colaReproduccion) {
            System.out.println(cancion);
        }
    }

    public void verHistorialReproduccion() {
        System.out.println("HISTORIAL DE REPRODUCCIÓN:");
        for (Cancion cancion : historialReproduccion) {
            System.out.println(cancion);
        }
    }
}

