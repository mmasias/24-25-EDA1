
public class Node extends Estado{

    private Node padre;
    private Lista lista;
    private Node siguiente;
    private Node anterior;

    public Node(int value, Node padre, Node siguiente, Node anterior) {
        super(value);
        this.padre = padre;
        this.lista = new Lista();
        this.siguiente = siguiente;
        this.anterior = anterior;

    }

    public String mostrar() {
        return getNumberFiles() + " archivos.";
    }

    public void añadirVersion(int value, Node padre) {
        lista.insertar(value, padre);
    }

    public Node getPadre(){
        return this.padre;
    }

    public Node getSiguiente(){
        return this.siguiente;
    }

    public Lista getLista(){
        return this.lista;
    }

    public void setSiguiente(int value, Node padre) {
        this.siguiente = new Node(value, padre, null, this);
    }

    public Node getAnterior() {
        return this.anterior;
    }
}
