package entregas.lopezMartin.reto_001b;

public class Dato {

    private int id;
    private String valor;
    private boolean activo;

    public Dato(String valor, int id){

        this.valor = valor;
        this.id = id;
        activo = true;
    }

    public int getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    public boolean isActivo() {
        return activo;
    }

    public void eliminar(){
        activo = false;
    }
    
}
