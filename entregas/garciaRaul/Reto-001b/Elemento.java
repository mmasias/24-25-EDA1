public class Elemento {
    int id;
    String dato;

    public Elemento(int id, String dato) {
        this.id = id;
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + dato;
    }
}

