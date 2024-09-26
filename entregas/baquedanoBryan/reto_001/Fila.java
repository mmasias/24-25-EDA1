package entregas.baquedanoBryan.reto_001;

public class Fila {

    private Cliente[] fila;
    private int capacidad;
    private int numClientes;

    public Fila(){
        this.capacidad = 15;
        this.fila = new Cliente[capacidad];
        this.numClientes = 0;
    }

    public boolean agregarCliente(Cliente cliente) {
        if (numClientes < capacidad) { 
            fila[numClientes] = cliente; 
            numClientes++;
            return true; 
        } else {
            System.out.println("Fila llena."); 
            return false; 
        }
    }

    public void atenderCliente() {
        if (numClientes > 0) { 
            Cliente atendido = fila[0]; 
            desplazarClientesIzquierda(); 
            numClientes--; 
        } else {
            System.out.println("No hay clientes en la fila."); 
        }
    }

    private void desplazarClientesIzquierda() {
        for (int i = 1; i < numClientes; i++) {
            fila[i - 1] = fila[i]; 
        }
        fila[numClientes - 1] = null; 
    }

    public void clienteAburrido() {
        if (numClientes > 1) {
            int aburrido = (int) (Math.random() * (numClientes - 1)) + 1; 
            eliminarClienteEnPosicion(aburrido); 
        } else if (numClientes == 1) {
            System.out.println("Solo queda un cliente en la fila, no se puede aburrir."); 
        } else {
            System.out.println("No hay clientes en la fila."); 
        }
    }

    private void eliminarClienteEnPosicion(int indice) {
        for (int i = indice; i < numClientes - 1; i++) {
            fila[i] = fila[i + 1]; 
        }
        fila[numClientes - 1] = null; 
        numClientes--; 
    }




    
}
