class Huevo extends Extras {

    final String DIBUJO = "~-~-(  )~-~-";

    protected Huevo() {
        super("Huevo");
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }

}
