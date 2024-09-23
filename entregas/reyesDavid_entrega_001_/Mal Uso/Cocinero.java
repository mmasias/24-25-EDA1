class Cocinero extends Empleado {

    private final Res carne = new Res("poco hecha");
    private final Pan brioche = new Brioche();
    private final Queso cheddar = new Cheddar();
    private final Salsa ketchup = new Ketchup("poco");
    private final Salsa mayonesa = new Mayonesa("mucho");
    private final Res huevo = new Huevo();

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 4;
        hamburguesa = new Hamburguesa(brioche, brioche, this.carne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(cheddar);
        hamburguesa.agregarExtra(ketchup);
        hamburguesa.agregarExtra(mayonesa);
        hamburguesa.agregarExtra(new Huevo());
        this.tieneHamburguesa = true;
    }

    public Hamburguesa entregar() {
        this.tieneHamburguesa = false;
        return hamburguesa;
    }
}
