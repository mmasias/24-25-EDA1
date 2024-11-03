package entregas.vaqueroInigo.reto004;

public class Nodo {
    Cancion dato;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(Cancion dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
