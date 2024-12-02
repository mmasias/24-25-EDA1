class SistemaReproduccion {
    private Cola<Cancion> colaReproduccion;
    private ListaEnlazada<Cancion> historial;
    private Cancion cancionActual;
    private boolean aleatorio;
    private boolean repetir;

    public SistemaReproduccion() {
        this.colaReproduccion = new Cola<>();
        this.historial = new ListaEnlazada<>();
    }

    public void agregarACola(Cancion cancion) {
        colaReproduccion.encolar(cancion);
    }

    public void reproducirSiguiente() {
        if (repetir && cancionActual != null) {
            System.out.println("Reproduciendo nuevamente: " + cancionActual);
        } else if (!colaReproduccion.estaVacia()) {
            cancionActual = colaReproduccion.desencolar();
            historial.agregar(cancionActual);
            System.out.println("▶ Reproduciendo: " + cancionActual);
        } else {
            System.out.println("No hay más canciones en la cola.");
        }
    }

    public void reproducirAnterior() {
        if (historial.estaVacia()) {
            System.out.println("No hay canción anterior.");
            return;
        }

        Nodo<Cancion> actual = historial.cabeza;
        Nodo<Cancion> penultimo = null;

        while (actual.siguiente != null) {
            penultimo = actual;
            actual = actual.siguiente;
        }


        if (penultimo != null) {
            cancionActual = penultimo.dato;
            penultimo.siguiente = null;
            System.out.println("▶ Reproduciendo canción anterior: " + cancionActual);
        } else {
            System.out.println("No hay más canciones en el historial.");
        }
    }

    public void verCola() {
        System.out.println("COLA DE REPRODUCCIÓN:");
        if (cancionActual != null) {
            System.out.println("1. ▶ " + cancionActual + " (ACTUAL)");
        }
        int i = 2;
        Nodo<Cancion> actual = colaReproduccion.frente;
        while (actual != null) {
            System.out.println(i++ + ". " + actual.dato);
            actual = actual.siguiente;
        }
    }

    public void verHistorial() {
        System.out.println("Historial de canciones reproducidas:");
        historial.mostrar();
    }

    public void activarAleatorio() {
        aleatorio = !aleatorio;
        System.out.println("Modo aleatorio " + (aleatorio ? "activado" : "desactivado"));
    }

    public void activarRepetir() {
        repetir = !repetir;
        System.out.println("Modo de repetición " + (repetir ? "activado" : "desactivado"));
    }

    public Cancion getCancionActual() {
        return cancionActual;
    }
}
