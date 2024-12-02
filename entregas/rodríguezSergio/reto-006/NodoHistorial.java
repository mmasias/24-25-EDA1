public class NodoHistorial {

    private int numeroLinea;
    private String contenido;
    private NodoHistorial siguiente;

    public NodoHistorial(int numeroLinea, String contenido) {
        this.numeroLinea = numeroLinea;
        this.contenido = contenido;
        this.siguiente = null;
    }

    public int obtenerNumero() {
        return numeroLinea;
    }

    public String obtenerContenido() {
        return contenido;
    }

    public NodoHistorial obtenerSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }
}