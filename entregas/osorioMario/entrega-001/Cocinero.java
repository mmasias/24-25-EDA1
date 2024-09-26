class Cocinero extends Empleado {
    private static Carne laCarne = new Res("poco hecha");
    private static Pan panSuperior = new Brioche();
    private static Pan panInferior = new Brioche();
    
    public void prepararHamburguesa() {
        hamburguesa = new Hamburguesa(panSuperior, panInferior, laCarne, 4);
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
