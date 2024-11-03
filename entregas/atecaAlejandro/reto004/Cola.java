package entregas.atecaAlejandro.reto004;

public class Cola {
    private Nodo frente;
    private Nodo fondo;
    public Cola() {
        frente = null;
        fondo = null;
    }
    public void agregar(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion);
        if (fondo != null) {
            fondo.siguiente = nuevo;
        }
        fondo = nuevo;
        if (frente == null) {
            frente = nuevo;
        }
    }
    public Cancion siguiente() {
        if (frente == null) {
            return null;
        }
        Cancion cancion = frente.cancion;
        frente = frente.siguiente;
        if (frente == null) {
            fondo = null;
        }
        return cancion;
    }
    public boolean estaVacia() {
        return frente == null;
    }
    public void mostrarCola() {
        Nodo actual = frente;
        int index = 1;
        while (actual != null) {
            System.out.println(index + ". " + actual.cancion);
            actual = actual.siguiente;
            index++;
        }
    }
}