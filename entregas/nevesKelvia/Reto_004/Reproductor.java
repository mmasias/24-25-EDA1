package entregas.nevesKelvia.Reto_004;

public class Reproductor {
    private ColaReproduccion cola = new ColaReproduccion();
    private HistorialReproduccion historial = new HistorialReproduccion();
    private Cancion cancionActual;

    public void reproducirSiguiente() {
        cancionActual = cola.desencolar();
        if (cancionActual != null) {
            System.out.println("Reproduciendo: " + cancionActual);
            historial.agregar(cancionActual);
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    public void mostrarCola() {
        cola.mostrarCola();
    }

    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    public void agregarCancionCola(Cancion cancion) {
        cola.encolar(cancion);
    }
}

