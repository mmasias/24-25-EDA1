package entregas.lopezMartin.reto-001;

import java.util.Random;

public class Fila {

    private Cliente[] clientes;
    private int posicionUltimo;

    public Fila(){

        clientes = new Cliente[150];
        posicionUltimo = 0;

    }

    public void añadirCliente(){
        clientes[posicionUltimo] = new Cliente();
        posicionUltimo++;
    }

    public void atenderCliente(){
        if(hayClientes()){
            liberarEspacio(clientes, 0, posicionUltimo+1);
            posicionUltimo--;
        }
    }

    private boolean hayClientes() {
        return clientes[0]!=null;
    }

    private void liberarEspacio(Cliente[] clientes, int indice, int elementosOcupados){
        assert indice >= 0 && indice < elementosOcupados;

        for (int i = indice; i < elementosOcupados - 1; i++) {
            clientes[i] = clientes[i + 1];
        }

        clientes[elementosOcupados - 1] = null;

    }

    public void clienteSeVa(){
        liberarEspacio(clientes, new Random().nextInt(posicionUltimo), posicionUltimo+1);
        posicionUltimo--;
    }
    
}
