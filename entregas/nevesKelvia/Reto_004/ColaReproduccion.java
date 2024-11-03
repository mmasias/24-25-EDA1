package entregas.nevesKelvia.Reto_004;

public class ColaReproduccion {
    private NodoCancion inicio;
    private NodoCancion fin;

    public void encolar(Cancion cancion) {
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

    public Cancion desencolar() {
        if (inicio == null) return null;
        Cancion cancion = inicio.cancion;
        inicio = inicio.siguiente;
        if (inicio != null) inicio.anterior = null;
        return cancion;
    }

    public void mostrarCola() {
        NodoCancion actual = inicio;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }
}
