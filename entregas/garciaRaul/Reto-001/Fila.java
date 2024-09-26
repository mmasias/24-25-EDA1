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
