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



    
}
