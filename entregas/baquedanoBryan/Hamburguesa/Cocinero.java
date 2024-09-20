

class Cocinero extends Empleado {

    private Carne laCarne;
    public Cocinero(){
        this.laCarne = new Res("poco hecha");
    }

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 4;
        hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), laCarne, NUMERO_EXTRAS);

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