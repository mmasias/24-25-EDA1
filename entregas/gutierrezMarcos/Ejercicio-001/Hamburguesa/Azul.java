class Azul extends Queso {
    final String REPRESENTACION = " " + "-·".repeat(6);

    public Azul() {
        super("Queso Azul");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}
