package entregas.Ejercicio_1_Buenuso;

public abstract class Salsa extends Extras {
    protected String cantidad;

    public Salsa(String nombre) {
        super(nombre);
    }

    @Override
    public String describir() {
        return cantidad + " de " + nombre;
    }
}