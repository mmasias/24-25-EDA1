public class ColeccionLineas {

    private NodoLinea inicio;
    private NodoLinea lineaActiva;

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
        lineaActiva = inicio;
    }

    public void mostrar() {
        NodoLinea actual = inicio;
        while (actual != null) {
            String marcador = actual == lineaActiva ? "* " : "  ";
            System.out.println(marcador + actual.obtenerNumero() + ": " + actual.obtenerContenido());
            actual = actual.getSiguiente();
        }
    }

    public void seleccionarLineaActiva(int numeroLinea) {
        NodoLinea actual = inicio;
        while (actual != null) {
            if (actual.obtenerNumero() == numeroLinea) {
                lineaActiva = actual;
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public void editarLinea(String contenido) {
        if (lineaActiva != null) {
            lineaActiva.establecerContenido(contenido);
        }
    }

    public void intercambiarLineas(int numero1, int numero2) {
        NodoLinea nodo1 = buscarNodo(numero1);
        NodoLinea nodo2 = buscarNodo(numero2);
        if (nodo1 != null && nodo2 != null) {
            String temp = nodo1.obtenerContenido();
            nodo1.establecerContenido(nodo2.obtenerContenido());
            nodo2.establecerContenido(temp);
        }
    }

    private NodoLinea buscarNodo(int numero) {
        NodoLinea actual = inicio;
        while (actual != null) {
            if (actual.obtenerNumero() == numero) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public String obtenerContenidoLineaActiva() {
        return lineaActiva != null ? lineaActiva.obtenerContenido() : "";
    }

    public int obtenerNumeroLineaActiva() {
        return lineaActiva != null ? lineaActiva.obtenerNumero() : -1;
    }

    public void deshacer(PilaHistorial deshacer, PilaHistorial rehacer) {
        if (!deshacer.estaVacia()) {
            Historial ultimaAccion = deshacer.desapilar();
            rehacer.guardar(obtenerNumeroLineaActiva(), obtenerContenidoLineaActiva());
            seleccionarLineaActiva(ultimaAccion.obtenerNumero());
            editarLinea(ultimaAccion.obtenerContenido());
        }
    }

    public void rehacer(PilaHistorial rehacer, PilaHistorial deshacer) {
        if (!rehacer.estaVacia()) {
            Historial accionRehacer = rehacer.desapilar();
            deshacer.guardar(obtenerNumeroLineaActiva(), obtenerContenidoLineaActiva());
            seleccionarLineaActiva(accionRehacer.obtenerNumero());
            editarLinea(accionRehacer.obtenerContenido());
        }
    }
}