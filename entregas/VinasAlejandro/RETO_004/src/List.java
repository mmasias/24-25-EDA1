abstract class List<T> {
    protected Node<T> head;

    public abstract void add(T data);

    public abstract T remove();

    public abstract boolean isEmpty();

    public <T> T get(int i) {
        return null;
    }
}

