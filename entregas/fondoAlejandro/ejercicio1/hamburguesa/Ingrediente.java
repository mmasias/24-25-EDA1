abstract class Ingrediente {
    protected String nombre;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    protected String getNombre() {
        return nombre;
    }
    
    protected abstract void mostrar();
    protected abstract String describir();
}