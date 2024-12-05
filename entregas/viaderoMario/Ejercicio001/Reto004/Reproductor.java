package Ejercicio001.Reto004;

import java.util.Random;

class Reproductor {
    public ListaEnlazada<Cancion> cola;
    private ListaEnlazada<Cancion> historial;
    private Cancion cancionActual;
    public boolean modoAleatorio;
    public boolean modoRepeticion;
    private Random random;

    public Reproductor() {
        cola = new ListaEnlazada<>();
        historial = new ListaEnlazada<>();
        modoAleatorio = false;
        modoRepeticion = false;
        random = new Random();
    }
    public void agregarCancionCola(Cancion cancion) {
        cola.agregar(cancion);
    }

    public void eliminarCancionCola(Cancion cancion) {
        cola.eliminar();
    }

    public Cancion getCancionActual() {
       return cancionActual;
    }

    public void reproducirCancion() {
        if (cancionActual != null) {
            System.out.println("Reproduciendo: " + cancionActual);
            historial.agregar(cancionActual);
            cancionActual.marcarComoReproducida(true);
        }
    }

    public void siguienteCancion() {
        if (modoRepeticion && cancionActual != null) {
            reproducirCancion();
        } else if (modoAleatorio && !cola.estaVacia()) {
            cancionActual = cola.getRandom(random);
            reproducirCancion();
        } else {
            cancionActual = cola.eliminar();
            reproducirCancion();
        }
    }

    public void cancionAnterior() {
        if (!historial.estaVacia()) {
            cancionActual = historial.eliminar();
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
        modoRepeticion = estado;
        System.out.println("Modo repetir " + (estado ? "activado" : "desactivado"));
    }

    public void verCola() {
        System.out.println("Cola de reproducción:");
        cola.mostrar();
    }

    public void verHistorial() {
        System.out.println("Historial de reproducción:");
        historial.mostrar();
    }
    public void reproducirPlaylist(Playlist playlist) {
        ListaEnlazada<Cancion> canciones = playlist.getCanciones();
        for (int i = 0; i < canciones.getTamaño(); i++) {
            cola.agregar(canciones.get(i));
        }
        siguienteCancion();
    }
}
