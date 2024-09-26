class Ketchup extends Salsa {
    final String REPRESENTACION = "ooOooOooOooO ";

    public Ketchup(String cantidad) {
        super("Ketchup", cantidad);
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}