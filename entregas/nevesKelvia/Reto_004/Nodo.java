package entregas.nevesKelvia.Reto_004;

class Nodo<Elemento> {
    Elemento dato;
    Nodo<Elemento> siguiente;

    public Nodo(Elemento dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}