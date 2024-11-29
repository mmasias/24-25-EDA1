class Res extends Carne{
    private String forma = " " + ":".repeat(12);
    
    protected Res(String coccion) {
        super("Res", coccion);
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
