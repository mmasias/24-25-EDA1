class SistemaReproduccion {
    private ColaReproduccion colaReproduccion;
    private HistorialReproduccion historialReproduccion;
    private Cancion cancionActual;
    private boolean modoAleatorio;
    private boolean modoRepeticion;

    public SistemaReproduccion() {
        colaReproduccion = new ColaReproduccion();
        historialReproduccion = new HistorialReproduccion();
        cancionActual = null;
        modoAleatorio = false;
        modoRepeticion = false;
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }

    public void reproducirSiguiente() {
        if (modoRepeticion && cancionActual != null) {
            System.out.println("Reproduciendo de nuevo: " + cancionActual);
            return;
        }

        if (colaReproduccion.estaVacia()) {
            System.out.println("No hay más canciones en la cola.");
            cancionActual = null;
            return;
        }

        cancionActual = colaReproduccion.desencolar();
        historialReproduccion.agregar(cancionActual);
        System.out.println("Reproduciendo: " + cancionActual);
    }

    public void reproducirAnterior() {
        NodoReproduccion actual = historialReproduccion.obtenerUltimoNodo();

        if (actual == null || actual.anterior == null) {
            System.out.println("No hay canción anterior en el historial.");
        } else {
            cancionActual = actual.anterior.cancion;
            System.out.println("Reproduciendo anterior: " + cancionActual);
        }
    }

    public void verCola() {
        System.out.println("Cola de reproducción:");
        colaReproduccion.mostrar();
    }

    public void verHistorial() {
        System.out.println("Historial de reproducción:");
        historialReproduccion.mostrar();
    }

    public void activarAleatorio() {
        modoAleatorio = !modoAleatorio;
        System.out.println("Modo aleatorio " + (modoAleatorio ? "activado" : "desactivado"));
    }

    public void activarRepetir() {
        modoRepeticion = !modoRepeticion;
        System.out.println("Modo repetición " + (modoRepeticion ? "activado" : "desactivado"));
    }
}
