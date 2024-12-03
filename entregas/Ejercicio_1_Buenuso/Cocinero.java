package entregas.Ejercicio_1_Buenuso;

class Cocinero extends Empleado {

    public void prepararHamburguesa(){}
    public void prepararHamburguesa(Carne laCarne) {
        final int NUMERO_EXTRAS = 4;
        Carne laCarne = new Res("poco hecha");
        hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), laCarne, NUMERO_EXTRAS);
        hamburguesa = new Hamburguesa(new Integral(), new Integral(), laCarne, NUMERO_EXTRAS);

        hamburguesa.agregarExtra(new Azul());
        hamburguesa.agregarExtra(new Ketchup("mucho"));
        hamburguesa.agregarExtra(new Mayonesa("poco"));
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