abstract class Carne extends Ingrediente{
    protected String coccion;

    protected Carne(String nombre, String coccion) {
        super(nombre);
        this.coccion = coccion;
    }

    protected abstract void mostrar();

    public String getCoccion() {
        return coccion;
    }
}