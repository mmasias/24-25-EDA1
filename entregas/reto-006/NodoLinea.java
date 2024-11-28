public class NodoLinea {

    private int numero;
    private String contenido;
    private NodoLinea siguiente;

    public NodoLinea(int numero) {
        this.numero = numero;
        this.contenido = "";
        this.siguiente = null;
    }

    public int obtenerNumero() {
        return numero;
    }

    public String obtenerContenido() {
        return contenido;
    }

    public void establecerContenido(String contenido) {
        this.contenido = contenido;
    }

    public NodoLinea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLinea siguiente) {
        this.siguiente = siguiente;
    }
}