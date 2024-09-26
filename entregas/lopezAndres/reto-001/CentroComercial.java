import java.util.Random;

public class CentroComercial {

    private Fila fila;
    private boolean abierto;
    private int tiempo;

    public CentroComercial(){
        fila = new Fila();
        abierto = true;
        tiempo = 1;
    }
}
