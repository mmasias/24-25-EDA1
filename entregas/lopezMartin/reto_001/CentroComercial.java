package entregas.lopezMartin.reto_001;

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

    public void simular(int duracion) {

        while(abierto){
            if(llegaCliente()){
                fila.añadirCliente();
            }
            atenderCliente();
            if(clienteSeAburre()){
                fila.clienteSeVa();
            }

            
            
            tiempo++;
            abierto = tiempo==duracion;
        }
    }

    private boolean clienteSeAburre() {
        return new Random().nextInt(100) < 10;
    }

    private void atenderCliente() {
        fila.atenderCliente();
    }

    private boolean llegaCliente() {
        return new Random().nextInt(100) < 50;
    }
    
}
