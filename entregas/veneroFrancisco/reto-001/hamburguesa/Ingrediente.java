public abstract class Ingrediente {
    protected String nombre;

    public String describir() {
        return nombre;
    }

    protected abstract void mostrar();  
}
