package entregas.naranjoDylan.reto004;

import java.util.Random;

public class Reproductor {
    private Lista colaReproduccion;
    private Lista historial;
    private Nodo cancionActual;
    private boolean modoAleatorio;
    private boolean modoRepeticion;
    private Random random;

    public Reproductor() {
        colaReproduccion = new Lista();
        historial = new Lista();
        cancionActual = null;
        modoAleatorio = false;
        modoRepeticion = false;
        random = new Random();
    }

    public void reproducirSiguiente(Lista biblioteca) {
        if (modoAleatorio) {
            reproducirAleatoria(biblioteca);
        } else if (colaReproduccion.cabeza != null) {
            if (cancionActual != null) {
                historial.agregar(cancionActual.dato);
            }
            cancionActual = colaReproduccion.cabeza;
            colaReproduccion.cabeza = colaReproduccion.cabeza.siguiente;
            System.out.println("▶ Reproduciendo: " + cancionActual.dato);
        } else if (modoRepeticion) {
            cancionActual = biblioteca.cabeza;
            System.out.println("▶ Reproduciendo: " + cancionActual.dato);
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    public void reproducirAleatoria(Lista biblioteca) {
        int totalCanciones = contarCanciones(biblioteca.cabeza);
        if (totalCanciones > 0) {
            int indiceAleatorio = random.nextInt(totalCanciones);
            Nodo nodoAleatorio = obtenerNodo(biblioteca.cabeza, indiceAleatorio);
            if (cancionActual != null) {
                historial.agregar(cancionActual.dato);
            }
            cancionActual = nodoAleatorio;
            System.out.println("▶ Reproduciendo (aleatorio): " + cancionActual.dato);
        } else {
            System.out.println("No hay canciones disponibles.");
        }
    }

    public void reproducirAnterior() {
        if (historial.cabeza != null) {
            Nodo anteriorCancion = historial.cabeza;
            historial.cabeza = historial.cabeza.siguiente;
            if (cancionActual != null) {
                colaReproduccion.agregar(cancionActual.dato);
            }
            cancionActual = anteriorCancion;
            System.out.println("▶ Reproduciendo: " + cancionActual.dato);
        } else {
            System.out.println("No hay canciones anteriores en el historial.");
        }
    }

    private int contarCanciones(Nodo nodo) {
        int count = 0;
        while (nodo != null) {
            count++;
            nodo = nodo.siguiente;
        }
        return count;
    }

    private Nodo obtenerNodo(Nodo cabeza, int indice) {
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public Nodo getCancionActual() {
        return cancionActual;
    }

    public void setCancionActual(Nodo cancionActual) {
        this.cancionActual = cancionActual;
    }

    public boolean isModoAleatorio() {
        return modoAleatorio;
    }

    public void setModoAleatorio(boolean modoAleatorio) {
        this.modoAleatorio = modoAleatorio;
    }

    public boolean isModoRepeticion() {
        return modoRepeticion;
    }

    public void setModoRepeticion(boolean modoRepeticion) {
        this.modoRepeticion = modoRepeticion;
    }

    public Lista getColaReproduccion() {
        return colaReproduccion;
    }

    public Lista getHistorial() {
        return historial;
    }
}