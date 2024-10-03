package src;

class Cocinero extends Empleado {

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 7;
        Carne laCarne = new Res("poco hecha");
        hamburguesa = new Hamburguesa(new Integral(), new Brioche(), laCarne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(new Cheddar());
        hamburguesa.agregarExtra(new Azul());
        hamburguesa.agregarExtra(new Huevo());
        hamburguesa.agregarExtra(new Mayonesa("mucho"));
        hamburguesa.agregarExtra(new Mayonesa("poco"));
        hamburguesa.agregarExtra(new Ketchup("poco"));
        hamburguesa.agregarExtra(new Ketchup("mucho"));
        this.tieneHamburguesa = true;
    }

    public Hamburguesa entregar() {
        this.tieneHamburguesa = false;
        return hamburguesa;
    }
}