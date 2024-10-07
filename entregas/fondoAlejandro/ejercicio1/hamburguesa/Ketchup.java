class Ketchup extends Extra{
    private String forma = " ooOooOooOooO";
    protected String cantidad;

    public Ketchup(String cantidad) {
        super("Ketchup");
        this.cantidad = cantidad;
    }

    @Override
    protected void mostrar() {
        System.out.println(forma);
    }

    @Override
    protected String describir() {
        return cantidad + " de " + nombre;
    }

    public String getCantidad() {
        return cantidad;
    }
}