import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class ReproductorMusica {
    private Queue<Cancion> colaReproduccion;
    private Stack<Cancion> historial;
    private boolean modoAleatorio;
    private boolean modoRepeticion;
    private Cancion cancionActual;

    public ReproductorMusica() {
        this.colaReproduccion = new LinkedList<>();
        this.historial = new Stack<>();
        this.modoAleatorio = false;
        this.modoRepeticion = false;
    }

    public void reproducir(Cancion cancion) {
        this.cancionActual = cancion;
        historial.push(cancion);
    }

    public void siguiente() {
    }

    public void anterior() {
    }

    public void activarAleatorio() {
        this.modoAleatorio = !modoAleatorio;
    }

    public void activarRepeticion() {
        this.modoRepeticion = !modoRepeticion;
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }

    public Queue<Cancion> getColaReproduccion() {
        return colaReproduccion;
    }

    public Stack<Cancion> getHistorial() {
        return historial;
    }
}