package Reto004;
public class ListaCircularCanciones {
    private NodoCancion cabeza;
    private NodoCancion actual;

    public ListaCircularCanciones() {
        this.cabeza = null;
        this.actual = null;
    }

    public void agregarCancion(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            actual = cabeza;
        } else {
            NodoCancion temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }
    }

    public Cancion obtenerCancionActual() {
        return actual.cancion;
    }

    public void avanzar() {
        if (actual != null) {
            actual = actual.siguiente;
        }
    }

    public void retroceder() {
        if (actual != null) {
            NodoCancion temp = cabeza;
            while (temp.siguiente != actual) {
                temp = temp.siguiente;
            }
            actual = temp;
        }
    }
    
    public void eliminar(String titulo) {
        if (cabeza == null) return;
        if (cabeza.cancion.getTitulo().equals(titulo)) {
            cabeza = cabeza.siguiente;
            return;
        }
        NodoCancion actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.cancion.getTitulo().equals(titulo)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    public void mostrarCanciones() {
        if (cabeza == null) return;
        NodoCancion temp = cabeza;
        int index = 1;
        do {
            System.out.println(index + ". " + temp.cancion);
            temp = temp.siguiente;
            index++;
        } while (temp != cabeza);
    }

    public void encolarSiguientes(ColaCanciones cola, int cantidad) {
        NodoCancion temp = actual;
        for (int i = 0; i < cantidad; i++) {
            temp = temp.siguiente;
            cola.encolar(temp.cancion);
        }
    }

    public Cancion obtenerCancion(int index) {
        if (cabeza == null) return null;
        NodoCancion temp = cabeza;
        int contador = 1;
        do {
            if (contador == index) {
                return temp.cancion;
            }
            temp = temp.siguiente;
            contador++;
        } while (temp != cabeza);
        return null;
    }
}