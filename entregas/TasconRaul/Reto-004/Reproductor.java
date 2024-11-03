import java.util.Random;

class Reproductor {
    private Cancion[] colaReproduccion;
    private Cancion[] historial;
    private int cantidadCola;
    private int cantidadHistorial;
    private boolean modoAleatorio = false;
    private boolean modoRepeticion = false;
    private Cancion cancionActual;

    public Reproductor(int capacidadCola, int capacidadHistorial) {
        colaReproduccion = new Cancion[capacidadCola];
        historial = new Cancion[capacidadHistorial];
        cantidadCola = 0;
        cantidadHistorial = 0;
    }

    public void agregarACola(Cancion cancion) {
        if (cantidadCola < colaReproduccion.length) {
            colaReproduccion[cantidadCola++] = cancion;
            System.out.println("Canción agregada a la cola: " + cancion);
        } else {
            System.out.println("La cola de reproducción está llena.");
        }
    }

    public void reproducirSiguiente() {
        if (cancionActual != null) {
            agregarAHistorial(cancionActual);
        }

        if (modoAleatorio) {
            reproducirAleatoria();
        } else if (cantidadCola > 0) {
            cancionActual = colaReproduccion[0];
            System.arraycopy(colaReproduccion, 1, colaReproduccion, 0, cantidadCola - 1);
            cantidadCola--;
            reproducirActual();
        } else if (modoRepeticion && cancionActual != null) {
            reproducirActual();
        } else {
            System.out.println("Fin de la cola de reproducción.");
            cancionActual = null;
        }
    }

    private void agregarAHistorial(Cancion cancion) {
        if (cantidadHistorial < historial.length) {
            historial[cantidadHistorial++] = cancion;
        } else {
            System.arraycopy(historial, 1, historial, 0, cantidadHistorial - 1);
            historial[cantidadHistorial - 1] = cancion;
        }
    }

    public void reproducirAnterior() {
        if (cantidadHistorial > 0) {
            cancionActual = historial[--cantidadHistorial];
            reproducirActual();
        } else {
            System.out.println("No hay canciones en el historial.");
        }
    }

    public void activarModoAleatorio(boolean estado) {
        this.modoAleatorio = estado;
        System.out.println("Modo aleatorio " + (estado ? "activado" : "desactivado"));
    }

    public void activarRepeticion(boolean estado) {
        this.modoRepeticion = estado;
        System.out.println("Modo repetición " + (estado ? "activado" : "desactivado"));
    }

    private void reproducirActual() {
        if (cancionActual != null) {
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay canción en reproducción.");
        }
    }

    private void reproducirAleatoria() {
        if (cantidadCola == 0) {
            System.out.println("No hay canciones en la cola para reproducir aleatoriamente.");
            return;
        }

        int indiceAleatorio = new Random().nextInt(cantidadCola);
        cancionActual = colaReproduccion[indiceAleatorio];
        reproducirActual();
    }

    public void verHistorial() {
        System.out.println("Historial de reproducción:");
        for (int i = 0; i < cantidadHistorial; i++) {
            System.out.println((i + 1) + ". " + historial[i]);
        }
    }

    public void verCola() {
        System.out.println("Cola de reproducción:");
        for (int i = 0; i < cantidadCola; i++) {
            System.out.println((i + 1) + ". " + colaReproduccion[i]);
        }
    }

    // Nuevo método: verCancionActual
    public void verCancionActual() {
        if (cancionActual != null) {
            System.out.println("Canción actual: " + cancionActual);
        } else {
            System.out.println("No hay una canción en reproducción actualmente.");
        }
    }
}
