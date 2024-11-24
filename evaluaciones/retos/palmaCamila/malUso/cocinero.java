package evaluaciones.retos.palmaCamila.malUso;

class Cocinero extends Empleado {

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 4;
        Carne laCarne = new Res("poco hecha");
        Pan elPanDeHamburguesa = new Brioche();
        hamburguesa = new Hamburguesa(elPanDeHamburguesa, elPanDeHamburguesa, laCarne, NUMERO_EXTRAS);

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