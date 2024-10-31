package entregas.lopezMartin.reto_004;

public class Nodo extends Cancion {
    
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Nodo anterior, Cancion cancion, Nodo siguiente){
        super(cancion);
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
