class Azul extends Extra{
    private String forma = " " + "-.".repeat(6);

    public Azul(String nombre) {
        super("Queso Azul");
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