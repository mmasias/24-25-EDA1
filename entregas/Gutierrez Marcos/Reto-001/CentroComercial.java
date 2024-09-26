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
                fila.aÃ±adirCliente();
            }
            fila.atenderCliente();
            if(clienteSeAburre()){
                fila.clienteSeVa();
            }
            fila.recibirItemsExternos();
            if (seCuelaClienteIlicitamente()) {
                int posicion = new Random().nextInt(fila.getPosicionUltimo()+1);
                fila.moverDerecha(posicion);
            }
            tiempo++;
            abierto = tiempo==duracion;
        }
    }

    private boolean clienteSeAburre() {
        return new Random().nextInt(100) < 10;
    }

    private boolean llegaCliente() {
        return new Random().nextInt(100) < 60;
    }

    private boolean seCuelaClienteIlicitamente() {
        return new Random().nextInt(100) < 10;
    }
    
}
