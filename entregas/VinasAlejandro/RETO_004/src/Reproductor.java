import java.util.Random;

class Reproductor {

    public Listalink<Cancion> colaReproduccion;
    private Listalink<Cancion> historial;
    private Cancion cancionActual;
    public boolean modoAleatorio;
    public boolean modoRepetir;
    private Random random;

    public Reproductor() {
        colaReproduccion = new Listalink<>();
        historial = new Listalink<>();
        modoAleatorio = false;
        modoRepetir = false;
        random = new Random();
    }
    public void agregarCancionCola(Cancion cancion) {
        colaReproduccion.add(cancion);
    }

    public void eliminarCancionCola(Cancion cancion) {
        colaReproduccion.remove();
    }

    public Cancion getCancionActual() {
       return cancionActual;
    }

    public void reproducirCancion() {
        if (cancionActual != null) {
            System.out.println("Reproduciendo: " + cancionActual);
            historial.add(cancionActual);
            cancionActual.setReproducida(true);
        }
    }

    public void siguienteCancion() {
        if (modoRepetir && cancionActual != null) {
            reproducirCancion();
        } else if (modoAleatorio && !colaReproduccion.isEmpty()) {
            cancionActual = colaReproduccion.getRandomElement(random);
            reproducirCancion();
        } else {
            cancionActual = colaReproduccion.remove();
            reproducirCancion();
        }
    }

    public void cancionAnterior() {
        if (!historial.isEmpty()) {
            cancionActual = historial.remove();
            reproducirCancion();
        } else {
            System.out.println("No hay historial de canciones anteriores.");
        }
    }

    public void activarModoAleatorio(boolean estado) {
        modoAleatorio = estado;
        System.out.println("Modo aleatorio " + (estado ? "activado" : "desactivado"));
    }

    public void activarModoRepetir(boolean estado) {
        modoRepetir = estado;
        System.out.println("Modo repetir " + (estado ? "activado" : "desactivado"));
    }

    public void verCola() {
        System.out.println("Cola de reproducción:");
        colaReproduccion.display();
    }

    public void verHistorial() {
        System.out.println("Historial de reproducción:");
        historial.display();
    }
    public void reproducirPlaylist(Playlist playlist) {
        Listalink<Cancion> canciones = playlist.getCanciones();
        for (int i = 0; i < canciones.getSize(); i++) {
            colaReproduccion.add(canciones.get(i));
        }
        siguienteCancion();
    }
}