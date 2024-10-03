package src;

abstract class Carne {
    protected String tipo;
    protected String coccion;
    protected String impresion;


    public String nombrar(){
        return tipo + " " + coccion;
    }

    public String mostrar(){
        return impresion;
    }
}