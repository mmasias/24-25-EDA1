class Playlist {
    private String nombre;
    private NodoReproduccion primerNodo;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.primerNodo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        NodoReproduccion nuevoNodo = new NodoReproduccion(cancion);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            NodoReproduccion actual = primerNodo;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
        }
    }

    public Cancion obtenerCancion(int indice) {
        NodoReproduccion actual = primerNodo;
        int contador = 0;

        while (actual != null && contador < indice) {
            actual = actual.siguiente;
            contador++;
        }

        if (actual == null) {
            System.out.println("Índice fuera de rango.");
            return null;
        } else {
            return actual.cancion;
        }
    }

    public void eliminarCancion(Cancion cancion) {
        NodoReproduccion actual = primerNodo;

        while (actual != null) {
            if (actual.cancion.equals(cancion)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    primerNodo = actual.siguiente;
                }

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                }
                break;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarCanciones() {
        NodoReproduccion actual = primerNodo;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.cancion);
            actual = actual.siguiente;
            indice++;
        }
    }
}
