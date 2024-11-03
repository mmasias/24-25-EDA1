package entregas.vaqueroInigo.reto004;

public class ListaCircular {
    private Nodo cabeza;
    private Nodo actual;

    public void agregar(Cancion dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }
    }

    public Cancion siguiente() {
        if (actual == null) {
            actual = cabeza;
        } else {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public void mostrar() {
        if (cabeza == null) return;
        Nodo temp = cabeza;
        do {
            System.out.println(temp.dato);
            temp = temp.siguiente;
        } while (temp != cabeza);
    }
}
