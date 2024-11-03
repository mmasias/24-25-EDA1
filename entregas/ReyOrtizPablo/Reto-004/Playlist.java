

public class Playlist {
    private String nombre;
    private NodoCancion cabeza;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.cabeza = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCancion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public void eliminarCancion(Cancion cancion) {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        if (cabeza.cancion.equals(cancion)) {
            cabeza = cabeza.siguiente;
            return;
        }
        NodoCancion actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.cancion.equals(cancion)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        } else {
            System.out.println("Canción no encontrada en la playlist.");
        }
    }

    public void mostrarCanciones() {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }
        NodoCancion actual = cabeza;
        int indice = 1;
        while (actual != null) {
            System.out.println(indice + ". " + actual.cancion);
            actual = actual.siguiente;
            indice++;
        }
    }
}
