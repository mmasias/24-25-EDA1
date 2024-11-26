package entregas.lopezMartin.reto_006;

public class Linea {

    private String contenido;
    private int indice;

    public Linea(int indice){
        this.contenido = "";
        this.indice = indice;

    }

    public String obtenerContenido(){
        return this.contenido;
    }

    public int obtenerIndice(){
        return this.indice;
    }

    
}
