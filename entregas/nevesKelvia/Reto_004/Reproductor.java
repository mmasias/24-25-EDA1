package entregas.nevesKelvia.Reto_004;

class Reproductor {
    private ListaEnlazada<Cancion> colaReproduccion;
    private ListaEnlazada<Cancion> historial;
    private Cancion cancionActual;
    private boolean modoAleatorio;
    private boolean modoRepetir;

    public Reproductor() {
        colaReproduccion = new ListaEnlazada<>();
        historial = new ListaEnlazada<>();
        modoAleatorio = false;
        modoRepetir = false;
    }

    public void añadirACola(Cancion cancion) {
        colaReproduccion.añadir(cancion);
    }

    public void reproducir() {
        if (colaReproduccion.estaVacia()) {
            System.out.println("La cola de reproducción está vacía.");
            return;
        }
        cancionActual = colaReproduccion.obtener(0);
        historial.añadir(cancionActual);
        System.out.println("▶ Reproduciendo: " + cancionActual.toString());
    }

    public void siguiente() {
        if (colaReproduccion.estaVacia()) {
            System.out.println("No hay más canciones en la cola.");
            return;
        }
        historial.añadir(cancionActual);
        cancionActual = colaReproduccion.obtener(1);
        System.out.println("▶ Reproduciendo: " + cancionActual.toString());
    }

    public void activarAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("Modo aleatorio: " + (modoAleatorio ? "ON" : "OFF"));
    }

    public void activarRepetir() {
        modoRepetir = !modoRepetir;
        System.out.println("Modo repetición: " + (modoRepetir ? "ON" : "OFF"));
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }
    
    public ListaEnlazada<Cancion> getColaReproduccion() {
        return colaReproduccion;
    }
    
}


