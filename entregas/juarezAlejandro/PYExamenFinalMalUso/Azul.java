class Azul extends Extras {
    final String DIBUJO = "-.-.-.-.-.-.";

    protected Azul() {
        super("Queso Azul");
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }
}
