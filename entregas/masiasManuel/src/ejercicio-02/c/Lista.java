package c;

class Lista {

	private Nodo primero;
	private Nodo ultimo;

	public Lista() {
		this.primero = null;
		this.ultimo = null;
	}

	public boolean isEmpty() {
		return this.primero == null;
	}

	public void insertFirst(Persona persona) {
		this.primero = new Nodo(persona, this.primero);
		if (this.ultimo == null) {
			this.ultimo = this.primero;
		}
	}

	public void insertLast(Persona persona) {
		this.ultimo = new Nodo(this.ultimo, persona);
		if (this.primero == null) {
			this.primero = this.ultimo;
		}
	}

	public Persona removePrimero() {
		Persona persona = this.primero.getPersona();
		this.primero = this.primero.getSiguiente();
		if (this.primero == null) {
			this.ultimo = null;
		} else {
			this.primero.setAnterior(null);
		}
		return persona;
	}

	public Persona removeUltimo() {
		Persona persona = this.ultimo.getPersona();
		this.ultimo = this.ultimo.getAnterior();
		if (this.ultimo == null) {
			this.primero = null;
		} else {
			this.ultimo.setSiguiente(null);
		}
		return persona;
	}

	public boolean incluye(Persona persona) {
		if (this.isEmpty())
			return false;
		Nodo current = this.primero;
		while (current.getSiguiente() != null &&
				!current.getPersona().equals(persona)) {
			current = current.getSiguiente();
		}
		return current.getPersona().equals(persona);
	}

	public void writeln() {
        System.out.println("LISTA");
		if (this.isEmpty()){
            System.out.println("Lista vacía");
		}
		Nodo current = this.primero;
		while (current!= null) {
			current.getPersona().muestrate();
			current = current.getSiguiente();
		}
        System.out.println("========");
	}

}