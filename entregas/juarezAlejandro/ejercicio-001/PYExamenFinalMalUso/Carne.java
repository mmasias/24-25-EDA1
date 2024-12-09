abstract class Carne extends Ingrediente {

    private String coccion;

    public Carne(String nombre, String coccion) {
        this.nombre = nombre;
        this.coccion = coccion;
    }

    public String describir() {
        return nombre + "(" + coccion + ")";
    }

    public abstract void mostrar();

    public static int verHashCode(Carne carne) {
        return System.identityHashCode(carne);
    }

}
