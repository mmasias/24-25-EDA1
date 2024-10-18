class Mayonesa extends Extra{
    private String forma = " " + "~=~".repeat(4);
    protected String cantidad;

    public Mayonesa(String cantidad) {
        super("Mayonesa");
        this.cantidad = cantidad;
    }
     
    @Override
    protected void mostrar() {
        System.out.println(forma);
    }
        
    @Override
    protected String describir() {
        return cantidad + " de " + nombre;
    }
        
    public String getCantidad() {
        return cantidad;
    }
}
