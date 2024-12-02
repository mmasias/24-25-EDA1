package entregas.lopezMartin.reto_006;

public class Version {

    private int indiceLinea;
    private String contenido;

    public Version(int indiceLinea, String contenido){

        this.indiceLinea = indiceLinea;
        this.contenido = contenido;

    }

    public int obtenerIndice(){
        return this.indiceLinea;
    }

    public String obtenerContenido(){
        return this.contenido;
    }
    
}
