public class PilaHistorial {

    private NodoHistorial cima;

    public PilaHistorial() {
        this.cima = null;
    }

    public void guardar(int numeroLinea, String contenido) {
        NodoHistorial nuevoNodo = new NodoHistorial(numeroLinea, contenido);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }

    public Historial desapilar() {
        if (cima == null) {
            return null;
        }
        Historial historial = new Historial(cima.obtenerNumero(), cima.obtenerContenido());
        cima = cima.obtenerSiguiente();
        return historial;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void limpiar() {
        cima = null;
    }
}