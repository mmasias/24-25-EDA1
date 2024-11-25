package entregas.lopezMartin.reto_005.reto_005a;
public class Lista {

    private Node primero; 

    public Lista() {
        this.primero = null;
    }

    public void insertar(int value, Node padre) {

        if (primero==null) {
            primero = new Node(value, padre, null, null);
        }else{
            Node current = primero;
            while(current.getSiguiente()!=null){
                current = current.getSiguiente();
            }
            current.setSiguiente(value, padre, current);
        }
         
    }

    public Node getUltimo() {
        
        if (primero==null) {
            return null;
        }else{
            Node current = primero;
            while(current.getSiguiente()!=null){
                current = current.getSiguiente();
            }
            return current;
        }

    }

    public Node getPrimero(){
        return this.primero;
    }

}