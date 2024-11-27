class Mayonesa extends Salsas {

    final String DIBUJO = "~=~~=~~=~~=~";

    public Mayonesa(String cantidad) {
        super("Mayonesa", cantidad);
    }

    @Override
    public void mostrar() {
        System.out.println(DIBUJO);
    }

}
