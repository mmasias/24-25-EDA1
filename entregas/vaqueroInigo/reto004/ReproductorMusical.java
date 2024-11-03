package entregas.vaqueroInigo.reto004;

public class ReproductorMusical {
    private BibliotecaMusical biblioteca;
    private ListaDoble listaReproduccion;
    private ListaCircular listaCircular;
    private Pila historial;
    private Cola cola;
    private boolean modoAleatorio;
    private boolean modoRepeticion;
    private Cancion cancionActual;

    public ReproductorMusical() {
        biblioteca = new BibliotecaMusical();
        listaReproduccion = new ListaDoble();
        listaCircular = new ListaCircular();
        historial = new Pila();
        cola = new Cola();
        modoAleatorio = false;
        modoRepeticion = false;
        cancionActual = null;
    }

    public void agregarCancionABiblioteca(Cancion cancion) {
        biblioteca.agregarCancion(cancion);
    }

    public void mostrarBiblioteca() {
        biblioteca.mostrar();
    }

    public void reproducirSiguiente() {
        cancionActual = listaCircular.siguiente();
        historial.apilar(cancionActual);
        System.out.println("Reproduciendo: " + cancionActual);
    }

    public void reproducirAnterior() {

    }

    public void verCancionActual() {
        if (cancionActual != null) {
            System.out.println("Canción actual: " + cancionActual);
        } else {
            System.out.println("No hay canción en reproducción.");
        }
    }

    public void activarModoAleatorio(boolean activar) {
        modoAleatorio = activar;
        System.out.println("Modo aleatorio " + (activar ? "activado" : "desactivado"));
    }

    public void activarModoRepeticion(boolean activar) {
        modoRepeticion = activar;
        System.out.println("Modo repetición " + (activar ? "activado" : "desactivado"));
    }
}
