package romeroAngel.reto004;
public class Node {

    private Cancion cancion;
    private Node siguiente;

    public Node(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion nuevaCancion) {
        this.cancion = nuevaCancion;
    }

    public Node getNext() {
        return siguiente;
    }

    public void setNext(Node siguiente) {
        this.siguiente = siguiente;
    }


    ///REVISAR///
    public void showInConsole(){
        System.out.println(cancion);
    }

}