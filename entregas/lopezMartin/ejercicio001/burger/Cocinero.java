package entregas.lopezMartin.ejercicio001.burger;

class Cocinero extends Empleado {

    public void prepararHamburguesa() {
        final int NUMERO_EXTRAS = 4;
        Carne laCarne = new Res("poco hecha");
        Queso azul = new Azul();
        Carne otraCarne = new Pollo("muy hecho");
        new Integral();
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
