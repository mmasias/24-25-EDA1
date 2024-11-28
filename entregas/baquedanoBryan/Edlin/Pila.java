public class Pila {
    private Nodo tope;

    public Pila() {
        tope = null; 
    }

    public void push(String[] estado) {
        Nodo nuevo = new Nodo(estado);  
        nuevo.siguiente = tope;        
        tope = nuevo;  
    }

    public String[] pop() {
        if (tope == null) return null;  
        String[] valor = tope.valor;    
        tope = tope.siguiente;          
        return valor;               
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
