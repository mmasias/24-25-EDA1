class Huevo extends Extra {
    private String forma = " " + "~-~-(  )~-~-";

    public Huevo() {
        super("Huevo");
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