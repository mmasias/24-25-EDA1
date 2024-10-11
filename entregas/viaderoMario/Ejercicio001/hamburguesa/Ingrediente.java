package Ejercicio001.hamburguesa;


abstract class Ingrediente {
    protected String nombre;

    public String describir() {
        return nombre;
    }

    public abstract void mostrar();  
}