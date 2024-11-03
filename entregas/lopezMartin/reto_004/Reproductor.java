package entregas.lopezMartin.reto_004;

import java.util.Random;

public class Reproductor {
    private Cola colaReproduccion;
    private ListaCanciones historial;
    private Cancion cancionActual;
    private boolean repetir;
    private boolean aleatorio;
    private Cancion[] cancionesDisponibles;
    private NodoCancion cancionEnHistorial;
    

    public Reproductor(Cancion[] cancionesDisponibles) { 
        this.colaReproduccion = new Cola();
        this.historial = new ListaCanciones();      
        this.cancionActual = null;
        this.repetir = false;
        this.aleatorio = false;
        this.cancionesDisponibles = cancionesDisponibles;
        this.cancionEnHistorial = null;
    }

    public Cancion getCancionActual(){
        return this.cancionActual;
    }

    public void reproducirCancion(Cancion cancion) {
        this.cancionActual = cancion;
        System.out.println("Canción actual: " + cancion.toString());
        historial.insertUltimo(cancion);
        this.cancionEnHistorial = historial.getUltimoNodo();
    }

    public void siguienteCancion() {
        if (repetir && cancionActual != null) {
            System.out.println("Repetir activado. Reproduciendo nuevamente: " + cancionActual.toString());
        } else if (aleatorio) {
            Random random = new Random();
            int index = random.nextInt(cancionesDisponibles.length);
            cancionActual = cancionesDisponibles[index];
            System.out.println("Reproduciendo aleatoriamente: " + cancionActual.toString());
        } else if (!colaReproduccion.isEmpty()) {
            colaReproduccion.desenqueue();
            if (!colaReproduccion.isEmpty()) {
                cancionActual = colaReproduccion.getPrimero().getCancion();
                System.out.println("Reproduciendo siguiente canción: " + cancionActual.toString());
            } else {
                System.out.println("No hay más canciones en la cola de reproducción.");
                cancionActual = null;
            }
        } else {
            System.out.println("La cola está vacía y no se ha activado el modo aleatorio.");
            cancionActual = null;
        }
        if (cancionActual != null) {
            historial.insertUltimo(cancionActual);
            this.cancionEnHistorial = historial.getUltimoNodo();
        }
    }

    public void cancionAnterior() {
        if (cancionEnHistorial != null && cancionEnHistorial.getAnterior() != null) {
            cancionEnHistorial = cancionEnHistorial.getAnterior();
            cancionActual = cancionEnHistorial.getCancion();
            System.out.println("Reproduciendo canción anterior: " + cancionActual.toString());
        } else {
            System.out.println("No hay canción anterior en el historial.");
        }
    }

    public void verCola() {
        colaReproduccion.mostrar();
        mostrarEstado();
    }

    public void verHistorial() {
        System.out.println("Historial de canciones reproducidas: ");
        System.out.println(historial.mostrar());
    }

    public void activarDesactivarAleatorio() {
        aleatorio = !aleatorio;
        System.out.println("Modo aleatorio " + (aleatorio ? "activado" : "desactivado"));
    }

    public void activarDesactivarRepeticion() {
        repetir = !repetir;
        System.out.println("Modo repetición " + (repetir ? "activado" : "desactivado"));
    }

    private void mostrarEstado(){
        
        String repeticion = repetir ? "ON" : "OFF";
        String aleatorio = this.aleatorio ? "ON" : "OFF";
        System.out.println("Estado: Reproducción normal | Repetición: " + repeticion + " | Aleatorio: " + aleatorio);
    }

    public void añadirCancionCola(int idCancion) {
        colaReproduccion.enqueue(cancionesDisponibles[idCancion-1]);
    }

    
}