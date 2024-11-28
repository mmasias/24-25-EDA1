package Ejercicio001.Reto004;

abstract class List<T> {
    public Nodo<T> cabeza;

    public abstract void agregar(T dato);

    public abstract T eliminar();

    public abstract boolean estaVacia();

    public <T> T get(int i) {
        return null;
    }
}
