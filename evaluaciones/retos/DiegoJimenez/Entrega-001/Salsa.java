abstract class Salsa extends Extra {
    private String cantidad;

    protected Salsa(String nombre, String cantidad) {
        super(nombre);
        this.cantidad = cantidad;
    }

    @Override
    public String describir() {
        return cantidad + " de " + super.describir();
    }

    public abstract void mostrar();
}