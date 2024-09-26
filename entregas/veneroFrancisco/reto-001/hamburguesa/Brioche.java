class Brioche extends Pan {
    final String REPRESENTACION = "##############";

    public Brioche() {
        super("Brioche");
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}