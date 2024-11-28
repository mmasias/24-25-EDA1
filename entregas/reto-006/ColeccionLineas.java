public class ColeccionLineas {
    private NodoLinea inicio;

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
}