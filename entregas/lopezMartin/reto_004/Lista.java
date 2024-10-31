package entregas.lopezMartin.reto_004;

public class Lista {
    
    private Nodo primero;
	private Nodo ultimo;

	public Lista() {
		this.primero = null;
		this.ultimo = null;
	}

	public Nodo getPrimero() {
		return this.primero;
	}

	public Nodo getultimo() {
		return this.ultimo;
	}

	public boolean isEmpty() {
		return this.primero == null;
	}

	public void insertPrimero(Cancion cancion) {
		this.primero = new Nodo(null, cancion, this.primero);
		if (this.ultimo == null) {
			this.ultimo = this.primero;
		}
	}

	public void insertUltimo(Cancion cancion) {
		this.ultimo = new Nodo(this.ultimo, cancion, null);
		if (this.primero == null) {
			this.primero = this.ultimo;
		}
	}

	public Cancion removePrimero() {
		Cancion cancion = this.primero;
		this.primero = this.primero.getSiguiente();
		if (this.primero == null) {
			this.ultimo = null;
		} else {
			this.primero.setAnterior(null);
		}
		return cancion;
	}

	public Cancion removeUltimo() {
		Cancion cancion = this.ultimo;
		this.ultimo = this.ultimo.getAnterior();
		if (this.ultimo == null) {
			this.primero = null;
		} else {
			this.ultimo.setSiguiente(null);
		}
		return cancion;
	}

	public boolean incluye(Cancion cancion) {
		if (this.isEmpty())
			return false;
		Nodo current = this.primero;
		while (current.getSiguiente() != null &&
				!current.equals(cancion)) {
			current = current.getSiguiente();
		}
		return current.equals(cancion);
	}
	
	public void writeln() {
        System.out.println("LISTA");
		if (this.isEmpty()){
            System.out.println("Lista vacía");
		}
		Nodo current = this.primero;
		while (current!= null) {
			current.toString();
			current = current.getSiguiente();
		}
        System.out.println("========");
	}

}
