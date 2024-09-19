class Pollo extends Carne {

    final String DIBUJO = ";;;;;;;;;;;;";

    public Pollo(String coccion) {
        super("Pollo", coccion);
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }

}
