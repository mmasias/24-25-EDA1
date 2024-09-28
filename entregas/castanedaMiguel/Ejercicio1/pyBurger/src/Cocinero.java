class Cocinero extends Empleado {
    final int NUMERO_EXTRAS = 4;
    final Carne laCarne = new Res("poco hecha");
    final Hamburguesa hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), laCarne, NUMERO_EXTRAS);
    public void prepararHamburguesa() {




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
