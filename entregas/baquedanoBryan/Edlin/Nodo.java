class Nodo {
    String[] valor;
    Nodo siguiente;

    Nodo(String[] valor) {
        this.valor = valor.clone();
        this.siguiente = null;
    }
}