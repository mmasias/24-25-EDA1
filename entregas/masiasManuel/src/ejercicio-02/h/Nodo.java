package h;
public class Nodo extends Persona {
    
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Nodo anterior, Persona persona, Nodo siguiente){
        super(persona);
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

	public Nodo getAnterior() {
		return this.anterior;
	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}

	public void setAnterior(Nodo previous) {
		this.anterior = previous;
		if (this.anterior != null) {
			this.anterior.siguiente = this;
		}
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
		if (this.siguiente != null) {
			this.siguiente.anterior = this;
		}
	}    
}
