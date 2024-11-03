package entregas.lopesBrenda.reto004;

public class ListaDobleCanciones {
    private NodoDoble inicio;
    private NodoDoble fin;

    private class NodoDoble {
        Cancion cancion;
        NodoDoble anterior;
        NodoDoble siguiente;

        public NodoDoble(Cancion cancion) {
            this.cancion = cancion;
        }
    }

    public void agregarCancion(Cancion cancion) {
        NodoDoble nuevoNodo = new NodoDoble(cancion);
        if (inicio == null) {
            inicio = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }

    public void eliminarCancion(Cancion cancion) {
        NodoDoble actual = inicio;
        while (actual != null) {
            if (actual.cancion.equals(cancion)) {
                if (actual.anterior != null) actual.anterior.siguiente = actual.siguiente;
                if (actual.siguiente != null) actual.siguiente.anterior = actual.anterior;
                if (actual == inicio) inicio = actual.siguiente;
                if (actual == fin) fin = actual.anterior;
                break;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarPlaylist() {
        NodoDoble actual = inicio;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }
}
}
