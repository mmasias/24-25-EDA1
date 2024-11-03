package entregas.vaqueroInigo.reto004;

public class Pila {
    private Nodo cima;

    public void apilar(Cancion dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public void mostrar() {
        Nodo actual = cima;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
