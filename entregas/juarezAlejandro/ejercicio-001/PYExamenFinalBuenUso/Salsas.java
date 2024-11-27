abstract class Salsas extends Extras {

    private String cantidad;

    protected Salsas(String nombre, String cantidad) {
        super(nombre);
        this.cantidad = cantidad;

    }

    @Override
    public String describir() {
        return cantidad + " de " + super.describir();
    }

    public abstract void mostrar();

}
