class Cocinero extends Empleado {

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 4;
        Carne laCarne = new Res("poco hecha");
        hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), laCarne, NUMERO_EXTRAS);
        Hamburguesa hamburguesa2 = new Hamburguesa(new Brioche(), new Brioche(), laCarne, NUMERO_EXTRAS);
        Hamburguesa hamburguesa3 = new Hamburguesa(new Integral(), new Integral(), laCarne, NUMERO_EXTRAS);
        Hamburguesa hamburguesa4 = new Hamburguesa(new Integral(), new Brioche(), laCarne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(new Cheddar());
        hamburguesa.agregarExtra(new Ketchup("poco"));
        hamburguesa.agregarExtra(new Mayonesa("mucho"));
        hamburguesa.agregarExtra(new Huevo());

        hamburguesa2.agregarExtra(new Cheddar());
        hamburguesa2.agregarExtra(new Ketchup("poco"));
        hamburguesa2.agregarExtra(new Mayonesa("mucho"));
        hamburguesa2.agregarExtra(new Huevo());

        hamburguesa3.agregarExtra(new Cheddar());
        hamburguesa3.agregarExtra(new Ketchup("poco"));
        hamburguesa3.agregarExtra(new Mayonesa("mucho"));
        hamburguesa3.agregarExtra(new Huevo());

        hamburguesa4.agregarExtra(new Cheddar());
        hamburguesa4.agregarExtra(new Ketchup("poco"));
        hamburguesa4.agregarExtra(new Mayonesa("mucho"));
        hamburguesa4.agregarExtra(new Huevo());

        this.tieneHamburguesa = true;
    }

    public Hamburguesa entregar() {
        this.tieneHamburguesa = false;

        return hamburguesa;
    }

}
