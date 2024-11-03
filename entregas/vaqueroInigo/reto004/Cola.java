package entregas.vaqueroInigo.reto004;

public class Cola {
    private Nodo frente, fondo;

    public void encolar(Cancion dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (fondo == null) {
            frente = fondo = nuevoNodo;
        } else {
            fondo.siguiente = nuevoNodo;
            fondo = nuevoNodo;
        }
    }

    public void mostrar() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
