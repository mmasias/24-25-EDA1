public class Caja {
    private int numero;
    private boolean atendiendo;
    private Persona cliente;

    public Caja(int numero){
        this.numero = numero;
        atendiendo=false;
    }

    public void recibe(Persona cliente){
        this.cliente = cliente;
        atendiendo = true;
    }
    
}
