package entregas.lopezMartin.reto_006;

public class NodoVersion extends Version{

    private NodoVersion siguiente;

    public NodoVersion(int indice, String contenido){
        super(indice, contenido);
        this.siguiente = null;

    }

    public void setSiguiente(NodoVersion siguiente) {
        this.siguiente = siguiente;
    }

    public NodoVersion obtenerSiguiente(){
        return this.siguiente;
    }
    
}
