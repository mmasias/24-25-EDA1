package entregas.nevesKelvia.Reto_004;

public class HistorialReproduccion {
    private NodoCancion top;

    public void agregar(Cancion cancion) {
        NodoCancion nuevoNodo = new NodoCancion(cancion);
        nuevoNodo.siguiente = top;
        top = nuevoNodo;
    }

    public void mostrarHistorial() {
        NodoCancion actual = top;
        while (actual != null) {
            System.out.println(actual.cancion);
            actual = actual.siguiente;
        }
    }s
}
