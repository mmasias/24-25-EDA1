class Cocinero extends Empleado {
    public Hamburguesa prepararHamburguesa(Carne carne) {
        final int NUMERO_EXTRAS = 4;
        Hamburguesa hamburguesa = new Hamburguesa(new Brioche(), new Brioche(), carne, NUMERO_EXTRAS);
        
        hamburguesa.agregarExtra(new Cheddar());
        hamburguesa.agregarExtra(new Ketchup("poco"));
        hamburguesa.agregarExtra(new Mayonesa("mucho"));
        hamburguesa.agregarExtra(new Huevo());
        
        return hamburguesa;
    }
}
