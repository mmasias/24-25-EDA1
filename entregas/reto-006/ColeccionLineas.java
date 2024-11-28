public class ColeccionLineas {
    private NodoLinea inicio;
    private PilaHistorial pilaDeshacer = new PilaHistorial();
    private PilaHistorial pilaRehacer = new PilaHistorial();

    public ColeccionLineas() {
        inicializarLineas();
    }

    private void inicializarLineas() {
        NodoLinea actual = null;
        for (int i = 1; i <= 10; i++) {
            NodoLinea nuevoNodo = new NodoLinea(i);
            if (inicio == null) {
                inicio = nuevoNodo;
                actual = inicio;
            } else {
                actual.setSiguiente(nuevoNodo);
                actual = nuevoNodo;
            }
        }
    }

    public void mostrar() {
        NodoLinea actual = inicio;
        while (actual != null) {
            System.out.println(actual.obtenerNumero() + ": " + actual.obtenerContenido());
            actual = actual.getSiguiente();
        }
    }

    public void seleccionarLineaActiva(int numeroLinea) {
        NodoLinea actual = inicio;
        while (actual != null) {
            if (actual.obtenerNumero() == numeroLinea) {
                System.out.println("Línea activa: " + numeroLinea);
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Número de línea no válido.");
    }
    
    public void editarLineaActiva(int numeroLinea, String contenido) {
        NodoLinea actual = inicio;
        while (actual != null) {
            if (actual.obtenerNumero() == numeroLinea) {
                actual.establecerContenido(contenido);
                System.out.println("Línea " + numeroLinea + " editada con contenido: " + contenido);
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Número de línea no válido.");
    }
    
    public void deshacer() {
        if (pilaDeshacer.estaVacia()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        Historial accion = pilaDeshacer.desapilar();
        NodoLinea linea = buscarNodo(accion.obtenerNumero());
        if (linea != null) {
            pilaRehacer.guardar(new Historial(linea.obtenerNumero(), linea.obtenerContenido()));
            linea.establecerContenido(accion.obtenerContenido());
        }
    }
    
    public void rehacer() {
        if (pilaRehacer.estaVacia()) {
            System.out.println("No hay acciones para rehacer.");
            return;
        }
        Historial accion = pilaRehacer.desapilar();
        NodoLinea linea = buscarNodo(accion.obtenerNumero());
        if (linea != null) {
            pilaDeshacer.guardar(new Historial(linea.obtenerNumero(), linea.obtenerContenido()));
            linea.establecerContenido(accion.obtenerContenido());
        }
    }
}