public class Integral extends Pan{
    private String forma = "|".repeat(14);
    
    public Integral() {
        super("Integral");
    }
    
    @Override
    public void mostrar() {
        System.out.println(forma);
    }
    
    @Override
    protected String describir() {
        return nombre;
    }
}