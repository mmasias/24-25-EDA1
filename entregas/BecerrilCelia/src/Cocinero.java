package src;

class Cocinero extends Empleado {

    public void prepararHamburguesa(Carne carne) {
        final int NUMERO_EXTRAS = 4;
        hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), carne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(new Cheddar());
        hamburguesa.agregarExtra(new Ketchup("poco"));
        hamburguesa.agregarExtra(new Mayonesa("mucho"));
        hamburguesa.agregarExtra(new Huevo());
        this.tieneHamburguesa = true;
    }

    public Hamburguesa entregar() {
        this.tieneHamburguesa = false;
        return hamburguesa;
    }
}
