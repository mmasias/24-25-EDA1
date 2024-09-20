class Camarero extends Empleado {
    private Hamburguesa hamburguesa;
    private boolean tieneHamburguesa;

    public void recibir(Hamburguesa hamburguesa) {
        this.hamburguesa = hamburguesa;
        tieneHamburguesa = true;
    }

    public void servir() {
        if (tieneHamburguesa) {
            System.out.println("Sale una " + hamburguesa.describir());
            hamburguesa.mostrar();
        }
    }
}
