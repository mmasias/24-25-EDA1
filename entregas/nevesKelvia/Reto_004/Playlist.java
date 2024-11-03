package entregas.nevesKelvia.Reto_004;

public class Playlist {
    private NodoCancion inicio;  
    private NodoCancion fin;     
    private String nombre;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.inicio = null;
        this.fin = null;
    }

    private class NodoCancion {
        private Cancion cancion;
        private NodoCancion siguiente;
        private NodoCancion anterior;

        public NodoCancion(Cancion cancion) {
            this.cancion = cancion;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (inicio == null) { 
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }
    }

    public void eliminarCancion(Cancion cancion) {
        NodoCancion actual = inicio;

        while (actual != null) {
            if (actual.cancion.equals(cancion)) {
                if (actual.anterior != null) { 
                    actual.anterior.siguiente = actual.siguiente;
                } else { 
                    inicio = actual.siguiente;
                }
                if (actual.siguiente != null) { 
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    fin = actual.anterior;
                }
                break;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrarCanciones() {
        NodoCancion actual = inicio;
        System.out.println("Playlist: " + nombre);
        while (actual != null) {
            System.out.println(actual.cancion.toString());
            actual = actual.siguiente;
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}

