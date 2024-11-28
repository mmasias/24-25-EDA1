public class Historial {

    private int numeroLinea;
    private String contenido;

    public Historial(int numeroLinea, String contenido) {
        this.numeroLinea = numeroLinea;
        this.contenido = contenido;
    }

    public int obtenerNumero() {
        return numeroLinea;
    }

    public String obtenerContenido() {
        return contenido;
    }
}
