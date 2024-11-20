class Brioche extends Pan{
    private String forma = "#".repeat(14);

    public Brioche() {
        super("Brioche");
    }

    @Override
    public void mostrar() {
        System.out.println(forma);
    }

    @Override
    protected String describir() {
        return nombre;
    }
}