class Cocinero extends Empleado {

    public void prepararHamburguesa(Carne laCarne) {
        final int NUMERO_EXTRAS = 4;
        hamburguesa = new Hamburguesa(new Integral(), new Integral(), laCarne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(new Azul());
        hamburguesa.agregarExtra(new Ketchup("mucho"));
        hamburguesa.agregarExtra(new Mayonesa("poco"));
        hamburguesa.agregarExtra(new Cheddar());

        this.tieneHamburguesa = true;
    }

    public Hamburguesa entregar() {
        this.tieneHamburguesa = false;
        return hamburguesa;
    }
}