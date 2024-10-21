public abstract class Carne extends Ingrediente {
    protected String admiteCocion;
    public Carne(String nombre,String admiteCocion){
        this.nombre = nombre;
        this.admiteCocion = admiteCocion;
    } 
    public  String describir(){
        return nombre + "("+admiteCocion+ ")";
    }
} 
