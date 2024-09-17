abstract class Extra {
    protected String tipo;
    protected String cantidad;
    protected String impresion;

    public String nombrar(){
        return tipo + " " + cantidad;
    }

    public String mostrar(){
        return impresion;
    }

}
