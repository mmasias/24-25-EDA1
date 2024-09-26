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

    public void cuelaLicita() {
        if (numClientes < capacidad) { 
            desplazarClientesDerecha(); 
            fila[0] = new Cliente((int) (Math.random() * 11)); 
            numClientes++; 
        } else {
            System.out.println("Fila llena."); 
        }
    }

    
    private void desplazarClientesDerecha() {
        for (int i = numClientes; i > 0; i--) {
            fila[i] = fila[i - 1]; 
        }
    }

    
    public void cuelaIlícita() {
        if (numClientes < capacidad) { 
            fila[numClientes] = new Cliente((int) (Math.random() * 15)); 
            numClientes++; 
        } else {
            System.out.println("Fila llena. No se puede colar ilícitamente."); 
        }
    }

        
        public void anunciarCambioDeFila() {
            System.out.println("Al haber mucha gente en una fila, se abre otra fila"); 
            int limite = Math.min(8, numClientes); 
            System.out.println("Clientes en la primera fila:");
            for (int i = 0; i < limite; i++) {
                System.out.println(fila[i]); 
            }
    
            if (numClientes > limite) {
                System.out.println("Clientes en la segunda fila:");
                for (int i = limite; i < numClientes; i++) {
                    System.out.println(fila[i]); 
                }
            } else {
                System.out.println("No hay clientes suficientes para una segunda fila."); 
            }
        }
    
        
        public void mostrarFila() {
            if (numClientes == 0) { 
                System.out.println("Fila vacía."); 
            } else {
                System.out.println("Clientes en fila:");
                for (int i = 0; i < numClientes; i++) {
                    System.out.println(fila[i]); 
                }
            }
        }

}
