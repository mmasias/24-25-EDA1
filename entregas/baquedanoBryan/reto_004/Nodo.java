public class Nodo {
    public Cancion dato; // Dato del nodo, que será de tipo Cancion
    public Nodo siguiente; // Puntero al siguiente nodo

    public Nodo(Cancion dato) {
        this.dato = dato; // Asignar el dato
        this.siguiente = null; // Inicialmente, el siguiente es null
    }

    // Método para obtener el dato
    public Cancion getDato() {
        return dato;
    }

    // Método para establecer el siguiente nodo
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Método para obtener el siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }
}
