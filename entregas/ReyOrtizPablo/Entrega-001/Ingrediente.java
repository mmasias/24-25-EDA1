public abstract class Ingrediente {
    protected String nombre;
    protected String forma;
   
    
    public String describir(){
        return nombre;
    }

    public String mostrar(){
        return forma;
    }
}
