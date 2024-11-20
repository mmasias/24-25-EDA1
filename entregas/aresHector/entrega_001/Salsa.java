public abstract class Salsa extends Extras{
    protected String cantidad;
    public Salsa(String nombre){
        super(nombre);
    }
    public String describir(){
        return cantidad + " de " + nombre;
    }
}