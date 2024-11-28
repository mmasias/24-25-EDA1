import java.util.Stack;

public class PilaHistorial {
    private Stack<Historial> pila;

    public PilaHistorial() {
        this.pila = new Stack<>();
    }

    public void guardar(Historial historial) {
        pila.push(historial);
    }

    public Historial desapilar() {
        return pila.isEmpty() ? null : pila.pop();
    }

    public boolean estaVacia() {
        return pila.isEmpty();
    }
}