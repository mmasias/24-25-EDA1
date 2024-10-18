package src;
class Ketchup extends Salsa {
    final String REPRESENTACION = " " + "ooO".repeat(4);

    public Ketchup(String cantidad) {
        super("Ketchup", cantidad);
    }

    @Override
    public void mostrar() {
        System.out.println(REPRESENTACION);
    }
}