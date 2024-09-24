class Cheddar extends Extra {
    protected String forma = " ============";

    public Cheddar() {
        super("Queso Cheddar");
    }

    @Override
    protected void mostrar() {
        System.out.println(forma);
    }

    @Override
    protected String describir() {
        return nombre;
    }
}