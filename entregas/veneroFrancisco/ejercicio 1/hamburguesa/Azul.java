class Azul extends Queso {
    final String REPRESENTACION = "-.-.-.-.-.-. ";

    public Azul() {
        super("Queso Azul");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}