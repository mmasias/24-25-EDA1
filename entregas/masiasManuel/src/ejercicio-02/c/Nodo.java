package c;

class Nodo  {

	private Nodo anterior;
	private Persona persona;
	private Nodo siguiente;

	public Nodo(Nodo anterior, Persona persona, Nodo siguiente) {
		this.setAnterior(anterior);
		this.persona = persona;
		this.setSiguiente(siguiente);
	}

	public Nodo(Persona persona, Nodo siguiente) {
		this(null, persona, siguiente);
	}

	public Nodo(Nodo anterior, Persona persona) {
		this(anterior, persona, null);
	}

	public Nodo getAnterior() {
		return this.anterior;
	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
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

	public Persona getPersona() {
		return new Persona(this.persona);
	}
}