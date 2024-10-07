class Pollo  extends Carne{
    private String forma = " " + ";".repeat(12);
    
    protected Pollo(String coccion) {
        super("Pollo", coccion);
    }

    @Override
    protected void mostrar() {
        System.out.println(forma);
    } 

    @Override
    protected String describir() {
        return nombre;
    }  
}