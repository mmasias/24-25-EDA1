class Ketchup extends Salsas {

    final String DIBUJO = "ooOooOooOooO";

    public Ketchup(String cantidad) {
        super("Ketchup", cantidad);
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }

}
