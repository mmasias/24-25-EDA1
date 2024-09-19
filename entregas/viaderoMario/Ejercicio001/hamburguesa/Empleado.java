package Ejercicio001.hamburguesa;

abstract class Empleado {
    protected Hamburguesa hamburguesa;
    protected boolean tieneHamburguesa;

    public Empleado() {
        this.tieneHamburguesa = false;
    }
}