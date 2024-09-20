class Camarero extends Empleado {
    
    public void recibir(Hamburguesa hamburguesa) {
        super.hamburguesa = hamburguesa;
        super.tieneHamburguesa = true;
    }

    public void servir() {
        System.out.println("Sale una " + hamburguesa.describir());
        hamburguesa.mostrar();
    }
}
