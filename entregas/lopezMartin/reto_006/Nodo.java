package entregas.lopezMartin.reto_006;

public class Nodo extends Linea{

    private Nodo siguiente;

    public Nodo(int indice){
        super(indice);
        this.siguiente = null;
    }

    public Nodo getSiguiente(){
        return this.siguiente;
    }

    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
    
}
