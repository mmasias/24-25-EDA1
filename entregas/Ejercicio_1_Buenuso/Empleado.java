package entregas.Ejercicio_1_Buenuso;

abstract class Empleado {
    protected Hamburguesa hamburguesa;
    protected boolean tieneHamburguesa;

    public Empleado() {
        this.tieneHamburguesa = false;
    }
}
